package yjp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import yjp.pojo.Strategy;

@Mapper
@Repository
public interface StrategyDao {
    // 查策略
    public Strategy getStrategy();
    // 改策略
    public boolean modifyStrategy(Strategy strategy);
}
