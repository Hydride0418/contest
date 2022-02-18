package yjp.controller;

<<<<<<< HEAD
import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.tokenizer.Result;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.sun.corba.se.spi.ior.ObjectKey;
=======
>>>>>>> 18ba691fabe248fe72b0d4a06072744a9f8d57fc
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

//    @PostMapping("/modify_admin")
//    @ResponseBody
//    public ModifyAdministratorResponse modifyAdmin(@RequestBody Administrator administrator) {
//        ModifyAdministratorResponse modifyAdministratorResponse = new ModifyAdministratorResponse();
//        modifyAdministratorResponse.generate(administratorService.modifyAdmin(administrator));
//        return modifyAdministratorResponse;
//    }

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

    @GetMapping("/export")
    @ResponseBody
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<Administrator> list = administratorService.listAdmin();
        // 通过工具类创建writer 写出到磁盘路径
//        ExcelWriter writer = ExcelUtil.getWriter(filesUploadPath + "/用户信息.xlsx");
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);
        //自定义标题别名
        writer.addHeaderAlias("name", "姓名");
        writer.addHeaderAlias("gender", "性别");
        writer.addHeaderAlias("organization", "所在单位");
        writer.addHeaderAlias("phone", "手机号");
        writer.addHeaderAlias("email", "邮箱");
        writer.addHeaderAlias("address", "地址");
        writer.addHeaderAlias("create_date", "创建时间");

        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("管理员信息", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();
    }

    @PostMapping("/import")
    @ResponseBody
    public boolean imp(MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        // 方式1：(推荐) 通过 javabean的方式读取Excel内的对象，但是要求表头必须是英文，跟javabean的属性要对应起来
//        List<User> list = reader.readAll(User.class);

        // 方式2：忽略表头的中文，直接读取表的内容
        List<List<Object>> list = reader.read(1);
        for (List<Object> row : list) {
            Administrator admin = new Administrator();
            admin.setName(row.get(0).toString());
            admin.setGender(Integer.parseInt(row.get(1).toString()));
            admin.setOrganization(row.get(2).toString());
            admin.setPhone(row.get(3).toString());
            admin.setEmail(row.get(4).toString());
            administratorService.saveAdmin(admin);
        }
        return true;
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
