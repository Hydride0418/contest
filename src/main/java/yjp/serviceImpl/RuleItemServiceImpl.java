package yjp.serviceImpl;

import org.springframework.stereotype.Service;
import yjp.dao.RuleItemDao;
import yjp.pojo.RuleItem;
import yjp.service.RuleItemService;

import java.util.List;

@Service
public class RuleItemServiceImpl implements RuleItemService {

    private final RuleItemDao ruleItemDao;

    public RuleItemServiceImpl(RuleItemDao ruleItemDao) {
        this.ruleItemDao = ruleItemDao;
    }

    @Override
    public List<RuleItem> queryRuleItem(Integer rule_id) {
        return ruleItemDao.queryRuleItem(rule_id);
    }
}
