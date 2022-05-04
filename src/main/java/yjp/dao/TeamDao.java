package yjp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import yjp.pojo.Question;
import yjp.pojo.Team;
import yjp.pojo.query.SelectionQuery;
import yjp.pojo.query.TeamAwardQuery;
import yjp.pojo.query.TeamQuery;

import java.util.List;

@Mapper
@Repository
public interface TeamDao {
    //返回所有团队
    public List<Team> listTeam();
    //返回团队和赛题名称
    public List<Team> list2Team();
    //增加一个团队并返回team_id
    public Integer addTeam(Team team);
    //设置一个团队的邀请码
    public boolean setInviteId(@Param("id") Integer id,
                               @Param("invite_id") String invite_id);
    //根据id删除一个团队
    public boolean deleteTeam(Integer id);
    //修改团队信息
    public boolean modifyTeam(Team Team);
    //根据id查一个团队的信息
    public Team getTeamById(Integer id);
    //根据id查work_path
    public String getWorkPath(Integer id);
    //审核参赛资格
    public boolean qualificationReview(Integer id);
    //批量审核通过
    public boolean batchSelectionReviewPass(@Param("idList") List<Integer> idList);
    //批量审核不通过
    public boolean batchSelectionReviewFail(@Param("idList") List<Integer> idList);
    //搜索选题信息（work + team）
    public List<Team> searchSelectionInfo(SelectionQuery selectionQuery);
    //搜索question+team
    public List<Question> searchTeamInfo(TeamQuery teamQuery);
    //搜索团队信息
    public List<Team> queryTeam(@Param("contest") String contest,
                                @Param("question") String question,
                                @Param("team_name") String team_name,
                                @Param("team_leader") String team_leader,
                                @Param("leader_school") String leader_school,
                                @Param("leader_phone") String leader_phone,
                                @Param("is_award") Integer is_award);
    //给团队添加奖项
    public boolean addAward(TeamAwardQuery teamAwardQuery);
//    //新建团队并返回team_id
//    public Integer addInvite(Team team);
    public boolean setWorkPath(Team team);
}


