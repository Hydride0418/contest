package yjp.serviceImpl;

import org.springframework.stereotype.Service;
import yjp.dao.RuleDao;
import yjp.pojo.Rule;
import yjp.service.RuleService;

import java.util.List;

@Service
public class RuleServiceImpl implements RuleService {

    private final RuleDao ruleDao;

    public RuleServiceImpl(RuleDao ruleDao) {
        this.ruleDao = ruleDao;
    }

    @Override
    public List<Rule> listRule() {
        return ruleDao.listRule();
    }

    @Override
    public boolean addRule(Rule rule) {
        return ruleDao.addRule(rule);
    }

    @Override
    public boolean invalidRule(Integer id) {
        return ruleDao.invalidRule(id);
    }

    @Override
    public Rule checkRule(Integer id) {
        return ruleDao.checkRule(id);
    }

    @Override
    public List<Rule> queryRule(String name) {
        return ruleDao.queryRule(name);
    }
}
