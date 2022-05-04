package yjp.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yjp.pojo.Batch;
import yjp.pojo.Rule;
import yjp.response.RuleResponse.AddRuleResponse;
import yjp.service.RuleService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

@RequestMapping("/rule")
@Controller
public class RuleController {

    private final RuleService ruleService;

    public RuleController(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    @GetMapping("/get")
    @ResponseBody
    public List<Rule> listRule() {
        return ruleService.listRule();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Rule getRuleInfo(@PathVariable("id") Integer id) {
        return ruleService.checkRule(id);
    }

    @PostMapping("/add_rule")
    @ResponseBody
    public AddRuleResponse addRule(@RequestBody Rule rule) {
        AddRuleResponse addRuleResponse = new AddRuleResponse();
        addRuleResponse.generate(ruleService.addRule(rule));
        return addRuleResponse;
    }

    @GetMapping("/invalid_rule")
    @ResponseBody
    public boolean InvalidRule(@RequestParam("rule_id") Integer id) {
        return ruleService.invalidRule(id);
    }

    @GetMapping("/query_rule")
    @ResponseBody
    public List<Rule> queryRule(@RequestParam("name") String name) {
        return ruleService.queryRule(name);
    }

    @GetMapping("/export")
    @ResponseBody
    public void export(HttpServletResponse response) throws Exception {
        List<Rule> list = ruleService.listRule();
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.addHeaderAlias("name", "指标名称");
        writer.addHeaderAlias("title_colu", "评分表表头数量");
        writer.addHeaderAlias("is_use_wei", "是否加权求和");
        writer.addHeaderAlias("is_valid", "是否有效");
        writer.addHeaderAlias("head_info", "表头信息");
        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("指标信息", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();
    }

}
