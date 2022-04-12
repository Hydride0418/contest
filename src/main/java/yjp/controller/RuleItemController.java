package yjp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import yjp.pojo.RuleItem;
import yjp.service.RuleItemService;

import java.util.List;

@Controller
@RequestMapping("/ruleItem")
public class RuleItemController {

    private final RuleItemService ruleItemService;

    public RuleItemController(RuleItemService ruleItemService) {
        this.ruleItemService = ruleItemService;
    }

    @GetMapping("/query_ruleItem")
    @ResponseBody
    public List<RuleItem> queryRuleItem(@RequestParam("rule_id") Integer rule_id) {
        return ruleItemService.queryRuleItem(rule_id);
    }
}
