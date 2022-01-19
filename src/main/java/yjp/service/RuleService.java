package yjp.service;

import yjp.pojo.Rule;

import java.util.List;

public interface RuleService {
    //返回所有评阅指标
    public List<Rule> listRule();
    //新增评阅指标
    public boolean addRule(Rule rule);
    //指标置为无效
    public boolean invalidRule(Integer id);
    //查看指标
    public Rule checkRule(Integer id);
}
