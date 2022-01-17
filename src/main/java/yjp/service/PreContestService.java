package yjp.service;

import yjp.pojo.PreContest;

import java.util.List;

public interface PreContestService {
    //新增奖项
    public boolean addPreContest(PreContest preContest);
    //删除奖项
    public boolean deletePreContest(Integer id);
    //分页展示奖项列表
    public List<PreContest> showPreContestList();
    //修改奖项信息
    public boolean modifyPreContestInfo(PreContest preContest);
}
