package yjp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import yjp.pojo.PreContest;

import java.util.List;

@Mapper
@Repository
public interface PreContestDao {
    //返回所有分赛
    public List<PreContest> listPreContest();
    //增加一个分赛
    public boolean addPreContest(PreContest preContest);
    //根据id删除一个分赛
    public boolean deletePreContest(Integer id);
    //修改分赛信息
    public boolean modifyPreContest(PreContest preContest);
}
