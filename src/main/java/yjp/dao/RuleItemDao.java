package yjp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import yjp.pojo.RuleItem;

import java.util.List;

@Mapper
@Repository
public interface RuleItemDao {

    //根据rule_id查找出所有的ruleItem
    public List<RuleItem> queryRuleItem(Integer rule_id);

}
