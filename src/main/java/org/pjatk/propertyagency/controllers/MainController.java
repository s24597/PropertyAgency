package org.pjatk.propertyagency.controllers;

import org.pjatk.propertyagency.entities.Consultant;
import org.pjatk.propertyagency.entities.Process;
import org.pjatk.propertyagency.services.ClientService;
import org.pjatk.propertyagency.services.ConsultantService;
import org.pjatk.propertyagency.services.ProcessService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;

@Controller
public class MainController {

    private final ConsultantService consultantService;
    private final ClientService clientService;
    private final ProcessService processService;

    public MainController(ConsultantService consultantService, ClientService clientService, ProcessService processService) {
        this.consultantService = consultantService;
        this.clientService = clientService;
        this.processService = processService;
    }

    @GetMapping("")
    public RedirectView showHomePage() {
        return new RedirectView("/consultant/dashboard");
    }

    @GetMapping("/consultant/dashboard")
    public String dashboard(Model model) {
        Consultant consultant = consultantService.findByWorkerId(1);
        model.addAttribute("welcome_consultant", "Welcome " + consultant.getName() + " " + consultant.getSurname());
        model.addAttribute("cases", consultantService.getCaseCompleted(consultant.getWorkerId()));
        model.addAttribute("bonus", consultantService.getSalaryBonus(consultant.getWorkerId()));
        model.addAttribute("clients", clientService.getClientBasic());
        return "dashboards/consultant";
    }

    @GetMapping("/consultant/processes/{id}")
    public String showProcesses(Model model, @PathVariable int id) {
        model.addAttribute("processes", processService.getAllProcessesForClient(id));
        return "consultant/showProcesses";
    }


    @GetMapping("/consultant/process/{id}")
    public String showProcessDetails(Model model, @PathVariable int id) {
        Process process = processService.getSpecificProcessData(id);
        if (process.getType() == Process.types.RENT) {
            model.addAttribute("process", processService.getSpecificProcessData(id));
            return "consultant/showProcessDetails";
        }
        return "dashboards/consultant";
    }

    @GetMapping("/consultant/process/{id}/extend")
    public String extendRent(Model model, @PathVariable int id) {
        model.addAttribute("processId", id);
        Process process = processService.getSpecificProcessData(id);
        model.addAttribute("process", process);

        return "consultant/extendRent";
    }

    @PostMapping("/processExtend")
    public RedirectView processExtend(Model model, @ModelAttribute Process process) {
        if (process.getRentEndDate().isAfter(LocalDate.now())) {
            processService.extendProcess(process.getRentEndDate(),process.getProcessId());
            return new RedirectView("/consultant/dashboard");
        }
        return new RedirectView("/consultant/dashboard");
    }

}