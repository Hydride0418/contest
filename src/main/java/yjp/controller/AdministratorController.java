package yjp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yjp.service.AdministratorService;

@Controller
@RequestMapping("/administrator")
public class AdministratorController {
    private final AdministratorService administratorService;

    public AdministratorController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @PostMapping("/modify_password")
    @ResponseBody
    public boolean modifyAdministratorPassword() {
        return true;
    }

    @PostMapping("/add_administrator")
    @ResponseBody
    public boolean updateAdministrator() {
        return true;
    }


}
