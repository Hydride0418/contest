package yjp.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yjp.pojo.Expert;
import yjp.response.ExpertResponse.*;
import yjp.service.ExpertService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/expert")
public class ExpertController {

    private final ExpertService expertService;

    public ExpertController(ExpertService expertService) {
        this.expertService = expertService;
    }

    @GetMapping("/get")
    @ResponseBody
    public List<Expert> listExpert() {
        return expertService.listExpert();
    }

    @PostMapping("/add_expert")
    @ResponseBody
    public AddExpertResponse addExpert(@RequestBody Expert expert) {
        AddExpertResponse addExpertResponse = new AddExpertResponse();
        addExpertResponse.generate(expertService.addExpert(expert));
        return addExpertResponse;
    }

//    @PostMapping("/import")
//    @ResponseBody
//    public boolean importExpert()

    @GetMapping("/delete_expert/{id}")
    @ResponseBody
    public DeleteExpertResponse deleteExpert(@PathVariable("id") Integer id) {
        DeleteExpertResponse deleteExpertResponse = new DeleteExpertResponse();
        deleteExpertResponse.generate(expertService.deleteExpert(id));
        return deleteExpertResponse;
    }

    @PostMapping("/empty_remarks")
    @ResponseBody
    public EmptyRemarksResponse emptyRemarks(@RequestBody List<Integer> idList) {
        EmptyRemarksResponse emptyRemarksResponse = new EmptyRemarksResponse();
        emptyRemarksResponse.generate(expertService.emptyRemarks(idList));
        return emptyRemarksResponse;
    }

    @PostMapping("/modify_expert")
    @ResponseBody
    public ModifyExpertResponse modifyExpert(@RequestBody Expert expert) {
        ModifyExpertResponse modifyExpertResponse = new ModifyExpertResponse();
        modifyExpertResponse.generate(expertService.modifyExpert(expert));
        return modifyExpertResponse;
    }

    @PostMapping("/modify_remark")
    @ResponseBody
    public ModifyRemarkResponse modifyRemark(@RequestBody Expert expert) {
        ModifyRemarkResponse modifyRemarkResponse = new ModifyRemarkResponse();
        modifyRemarkResponse.generate(expertService.modifyRemark(expert));
        return modifyRemarkResponse;
    }

    @PostMapping("/modify_remarks")
    @ResponseBody
    public ModifyRemarksResponse modifyRemarks(@RequestBody List<Expert> expertList) {
        ModifyRemarksResponse modifyRemarksResponse = new ModifyRemarksResponse();
        modifyRemarksResponse.generate(expertService.modifyRemarks(expertList));
        return modifyRemarksResponse;
    }

    @GetMapping("/query_expert")
    @ResponseBody
    public List<Expert> queryExpert(@RequestParam("name") String name,
                                    @RequestParam("organization_name") String organization_name,
                                    @RequestParam("major_name") String major_name,
                                    @RequestParam("phone") String phone,
                                    @RequestParam("research_direction") String research_direction,
                                    @RequestParam("remarks") String remarks) {
        Expert expert = new Expert();
        expert.setName(name);
        expert.setOrganization_name(organization_name);
        expert.setMajor_name(major_name);
        expert.setResearch_direction(research_direction);
        expert.setRemarks(remarks);
        return expertService.queryExpert(expert);
    }

    @GetMapping("/export")
    @ResponseBody
    public void export(HttpServletResponse response) throws Exception {
        List<Expert> list = expertService.listExpert();
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.addHeaderAlias("name", "姓名");
        writer.addHeaderAlias("gender", "性别");
        writer.addHeaderAlias("organization_name", "所在单位");
        writer.addHeaderAlias("phone", "手机号");
        writer.addHeaderAlias("email", "邮箱");
        writer.addHeaderAlias("major_name", "专业名称");
        writer.addHeaderAlias("research_direction", "研究方向");
        writer.addHeaderAlias("remarks", "评阅备注");
        writer.addHeaderAlias("create_date", "创建时间");
        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("专家信息", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();
    }

}
