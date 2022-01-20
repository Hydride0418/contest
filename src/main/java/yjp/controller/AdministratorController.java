package yjp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import yjp.pojo.Administrator;
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
    public boolean modifyAdministratorPassword(@RequestParam("administrator") Administrator administrator,
                                               @RequestParam("oldPassword") String oldPassword,
                                               @RequestParam("newPassword1") String newPassword1,
                                               @RequestParam("newPassword2") String newPassword2) {
        String password = administrator.getPassword();
        if (password.equals(oldPassword) == false) {
            System.out.println("No match for old password.");
            return false;
        }
        else if (newPassword1.equals(newPassword2) == false) {
            System.out.println("New passwords are different.");
            return false;
        }
        else if (newPassword1.length() < 8) {
            System.out.println("The new password is less than 8 characters.");
            return false;
        }
        else if (newPassword1.length() > 20) {
            System.out.println("The new password is more than 20 characters.");
            return false;
        }
        else {
            administratorService.modifyAdministratorPassword(administrator, newPassword1);
            System.out.println("The password modified successfully.");
            return true;
        }
    }

    @PostMapping("/add_administrator")
    @ResponseBody
    public boolean updateAdministrator() {
        return true;
    }


}
