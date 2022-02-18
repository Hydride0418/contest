package yjp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import yjp.pojo.Question;
import yjp.pojo.Team;
import yjp.pojo.query.SelectionQuery;
import yjp.pojo.query.TeamQuery;

import java.util.List;

@Mapper
@Repository
public interface TeamDao {
    //返回所有团队
    public List<Team> listTeam();
    //增加一个团队
    public boolean addTeam(Team team);
    //根据id删除一个团队
    public boolean deleteTeam(Integer id);
    //修改团队信息
    public boolean modifyTeam(Team Team);
    //根据id查一个团队的信息
    public Team getTeamById(Integer id);
    //审核参赛资格
    public boolean qualificationReview(Integer id);
    //批量审核选题
    public boolean batchSelectionReview(@Param("idList") List<Integer> idList);
    //搜索选题信息（work + team）
    public List<Team> searchSelectionInfo(SelectionQuery selectionQuery);
    //搜索question+team
    public List<Question> searchTeamInfo(TeamQuery teamQuery);
}
