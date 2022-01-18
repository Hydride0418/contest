package yjp.service;

import yjp.pojo.Team;

import java.util.List;

public interface TeamService {
    //新增团队
    public boolean addTeam(Team team);
    //分页展示团队列表
    public List<Team> showTeamList();
    //修改团队信息
    public boolean modifyTeamInfo(Team team);
    //删除团队
    public boolean deleteTeam(Integer id);
    //根据id查一个团队的信息
    public Team getTeamById(Integer id);
    //审核参赛资格
    public boolean qualificationReview(Integer id);
    //批量审核选题
    public boolean batchSelectionReview(List<Integer> id);
}
