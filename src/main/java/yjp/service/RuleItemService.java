package yjp.service;

import yjp.pojo.RuleItem;

import java.util.List;

public interface RuleItemService {

    //根据rule_id查找出所有的ruleItem
    public List<RuleItem> queryRuleItem(Integer rule_id);

}
