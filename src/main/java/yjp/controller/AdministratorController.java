package yjp.controller;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import yjp.pojo.Administrator;
import yjp.response.AdministratorResponse.AddAdministratorResponse;
import yjp.response.AdministratorResponse.DeleteAdministratorResponse;
import yjp.response.AdministratorResponse.ModifyAdministratorResponse;
import yjp.service.AdministratorService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "http://localhost:5000", maxAge = 3600)
@Controller
@RequestMapping("/admin")
public class AdministratorController {

    private final AdministratorService administratorService;

    public AdministratorController(AdministratorService administratorService) {this.administratorService = administratorService;
    }

    @GetMapping("/get")
    @ResponseBody
    public List<Administrator> getAdminList() {
        return administratorService.listAdmin();
    }

    @PostMapping("/save_admin")
    @ResponseBody
    public AddAdministratorResponse addAdmin(@RequestBody Administrator administrator) {
        AddAdministratorResponse addAdministratorResponse = new AddAdministratorResponse();
        addAdministratorResponse.generate(administratorService.saveAdmin(administrator));
        return addAdministratorResponse;
    }

    @GetMapping("/delete_admin/{id}")
    @ResponseBody
    public DeleteAdministratorResponse deleteAdmin(@PathVariable("id") Integer id) {
        DeleteAdministratorResponse deleteAdministratorResponse = new DeleteAdministratorResponse();
        deleteAdministratorResponse.generate(administratorService.deleteAdmin(id));
        return deleteAdministratorResponse;
    }

    @GetMapping("/query_admin")
    @ResponseBody
    public Map<String, Object> queryAdmin(@RequestParam("name") String name,
                                          @RequestParam("organization") String organization,
                                          @RequestParam("phone") String phone,
                                          @RequestParam("pageNum") Integer pageNum,
                                          @RequestParam("pageSize") Integer pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        List<Administrator> data = administratorService.queryAdmin(name, organization, phone, pageNum, pageSize);
        Integer total = administratorService.queryNum(name, organization, phone).size();
        Map<String, Object> res = new HashMap<>();
        res.put("total", total);
        res.put("data", data);
        return res;
    }

    @GetMapping("/query_num")
    @ResponseBody
    public List<Administrator> findPage(@RequestParam("name") String name,
                                        @RequestParam("organization") String organization,
                                        @RequestParam("phone") String phone) {
        return administratorService.queryNum(name, organization, phone);
    }

}
