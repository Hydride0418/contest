package yjp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yjp.pojo.Batch;
import yjp.pojo.Rule;
import yjp.response.RuleResponse.AddRuleResponse;
import yjp.service.RuleService;

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

}
