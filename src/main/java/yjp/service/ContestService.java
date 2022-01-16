package yjp.service;

import org.springframework.stereotype.Service;
import yjp.pojo.Contest;
import yjp.pojo.query.ContestQuery;

import java.util.List;

public interface ContestService {
    //发起赛事
    public boolean addContest(Contest contest);
    //分页展示赛事列表
    public List<Contest> showContestList();
    //搜索赛事并分页展示
    public List<Contest> searchContest(ContestQuery contestQuery);
    //修改赛事信息
    public boolean modifyContestInfo(Contest contest);
}
