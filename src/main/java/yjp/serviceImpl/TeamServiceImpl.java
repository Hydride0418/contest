package yjp.serviceImpl;

import org.springframework.stereotype.Service;
import yjp.dao.TeamDao;
import yjp.pojo.Team;
import yjp.service.TeamService;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamDao teamDao;

    public TeamServiceImpl(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    @Override
    public boolean addTeam(Team team) {
        boolean success = teamDao.addTeam(team);
        return success;
    }

    @Override
    public List<Team> showTeamList() {
        List<Team> teamList = teamDao.listTeam();
        return teamList;
    }

    @Override
    public boolean modifyTeamInfo(Team team) {
        boolean success = teamDao.modifyTeam(team);
        return success;
    }

    @Override
    public boolean deleteTeam(Integer id) {
        boolean success = teamDao.deleteTeam(id);
        return success;
    }

    @Override
    public Team getTeamById(Integer id) {
        Team team = teamDao.getTeamById(id);
        return team;
    }

    @Override
    public boolean qualificationReview(List<Integer> idList) {
        boolean success =  teamDao.qualificationReview(idList);
        return success;
    }
}
