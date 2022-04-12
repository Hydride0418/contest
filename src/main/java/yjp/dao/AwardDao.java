package yjp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import yjp.pojo.Award;
import yjp.pojo.query.AwardQuery;

import java.util.List;

@Mapper
@Repository
public interface AwardDao {
    //返回所有奖项
    public List<Award> listAward();
    //增加一个奖项
    public boolean addAward(Award award);
    //根据id删除一个奖项
    public boolean deleteAward(Integer id);
    //搜索奖项
    public List<Award> searchAward(AwardQuery awardQuery);
    //修改奖项信息
    public boolean modifyAward(Award award);
    //增加团队奖项
    public boolean addTeamAward(Integer team_id);
    //增加机构奖项
    public boolean addOrgAward(Integer org_id);
}
