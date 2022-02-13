package yjp.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yjp.pojo.Administrator;
import yjp.response.AdministratorResponse.AddAdministratorResponse;
import yjp.response.AdministratorResponse.DeleteAdministratorResponse;
import yjp.response.AdministratorResponse.ModifyAdministratorResponse;
import yjp.service.AdministratorService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdministratorController {

    private final AdministratorService administratorService;

    public AdministratorController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @GetMapping("/get")
    @ResponseBody
    public List<Administrator> getAdminList() {
        return administratorService.listAdmin();
    }

    @PostMapping("/add_admin")
    @ResponseBody
    public AddAdministratorResponse addAdmin(@RequestBody Administrator administrator) {
        AddAdministratorResponse addAdministratorResponse = new AddAdministratorResponse();
        addAdministratorResponse.generate(administratorService.addAdmin(administrator));
        return addAdministratorResponse;
    }

    @GetMapping("/delete_admin/{id}")
    @ResponseBody
    public DeleteAdministratorResponse deleteAdmin(@PathVariable("id") Integer id) {
        DeleteAdministratorResponse deleteAdministratorResponse = new DeleteAdministratorResponse();
        deleteAdministratorResponse.generate(administratorService.deleteAdmin(id));
        return deleteAdministratorResponse;
    }

    @PostMapping("/modify_admin")
    @ResponseBody
    public ModifyAdministratorResponse modifyAdmin(@RequestBody Administrator administrator) {
        ModifyAdministratorResponse modifyAdministratorResponse = new ModifyAdministratorResponse();
        modifyAdministratorResponse.generate(administratorService.modifyAdmin(administrator));
        return modifyAdministratorResponse;
    }

    @GetMapping("/query_admin")
    @ResponseBody
    public List<Administrator> queryAdmin(@RequestParam("name") String name,
                                          @RequestParam("organization") String organization,
                                          @RequestParam("phone") String phone) {
        Administrator admin = new Administrator();
        admin.setName(name);
        admin.setOrganization(organization);
        admin.setPhone(phone);
        return administratorService.queryAdmin(admin);
    }

}
