package yjp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yjp.dao.StrategyDao;
import yjp.pojo.Strategy;
import yjp.service.StrategyService;

@Service
public class StrategyServiceImpl implements StrategyService {

    private final StrategyDao strategyDao;

    public StrategyServiceImpl(StrategyDao strategyDao) {
        this.strategyDao = strategyDao;
    }

    @Override
    public Strategy getStrategy() {
        System.out.println("1111111");
        return strategyDao.getStrategy();
    }

    @Override
    public boolean modifyStrategy(Strategy strategy) {
        return strategyDao.modifyStrategy(strategy);
    }
}
