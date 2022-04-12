package yjp.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import yjp.pojo.Organization;
import yjp.pojo.Team;
import yjp.service.OrganizationService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/org")
public class OrganizationController {
    public final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/query_org")
    @ResponseBody
    public List<Organization> queryMaster(@RequestParam("name") String name,
                                          @RequestParam("is_award") Integer is_award) {
        Organization organization = new Organization();
        organization.setName(name);
        organization.setIs_award(is_award);
        return organizationService.queryOrganization(organization);
    }

    @GetMapping("/export")
    @ResponseBody
    public void export(HttpServletResponse response) throws Exception {
        List<Organization> list = organizationService.listOrg();
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.addHeaderAlias("name", "学校名称");
        writer.addHeaderAlias("organization_id", "学校代号");
        writer.addHeaderAlias("team_num", "参赛队伍数");
        writer.addHeaderAlias("stu_num", "参赛学生数");
        writer.addHeaderAlias("tea_num", "指导老师数");
        writer.addHeaderAlias("is_award", "是否获奖");
        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("参赛机构获奖情况", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();
    }

}
