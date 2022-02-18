package yjp.service;

import yjp.pojo.Award;
import yjp.pojo.Contest;
import yjp.pojo.query.AwardQuery;
import yjp.pojo.query.ContestQuery;

import java.util.List;

public interface AwardService {
    //新增奖项
    public boolean addAward(Award award);
    //删除奖项
    public boolean deleteAward(Integer id);
    //分页展示奖项列表
    public List<Award> showAwardList();
    //搜索奖项并分页展示
    public List<Award> searchAward(AwardQuery awardQuery);
    //修改奖项信息
    public boolean modifyAwardInfo(Award award);
}
