package yjp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import yjp.pojo.Team;

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
}
