package yjp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import yjp.pojo.Contest;
import yjp.pojo.query.ContestQuery;

import java.util.List;

@Mapper
@Repository
public interface ContestDao {
    //返回所有赛事的列表
    public List<Contest> listContest();
    //增加一个赛事
    public boolean addContest(Contest contest);
    //修改赛事信息
    public boolean modifyContest(Contest contest);
    //查询赛事
    public List<Contest> searchContest(ContestQuery contestQuery);
    //设置图片信息
    public boolean setImageUrl(Contest contest);
    //
    public Contest getContest(Integer id);
}
