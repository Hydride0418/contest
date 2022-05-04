package yjp.service;
import yjp.pojo.Strategy;

public interface StrategyService {
    // 查策略
    public Strategy getStrategy();
    // 改策略
    public boolean modifyStrategy(Strategy strategy);
}
