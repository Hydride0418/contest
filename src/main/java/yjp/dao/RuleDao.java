package yjp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import yjp.pojo.Rule;

import java.util.List;

@Mapper
@Repository
public interface RuleDao {
    //返回所有评阅指标
    public List<Rule> listRule();
    //新增评阅指标
    public boolean addRule(Rule rule);
    //指标置为无效
    public boolean invalidRule(Integer id);
    //查看指标
    public Rule checkRule(Integer id);
}
