package yjp.serviceImpl;

import org.springframework.stereotype.Service;
import yjp.dao.TeamDao;
import yjp.pojo.Question;
import yjp.pojo.Team;
import yjp.pojo.query.SelectionQuery;
import yjp.pojo.query.TeamAwardQuery;
import yjp.pojo.query.TeamQuery;
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
    public List<Team> list2Team() {
        return teamDao.list2Team();
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
    public boolean qualificationReview(Integer id) {
        boolean success =  teamDao.qualificationReview(id);
        return success;
    }

    @Override
    public boolean batchSelectionReview(List<Integer> idList) {
        boolean success = teamDao.batchSelectionReview(idList);
        return success;
    }

    @Override
    public List<Team> searchSelectionInfo(SelectionQuery selectionQuery) {
        return teamDao.searchSelectionInfo(selectionQuery);
    }

    @Override
    public List<Question> searchTeamInfo(TeamQuery teamQuery) {
        return teamDao.searchTeamInfo(teamQuery);
    }

    @Override
    public List<Team> queryTeam(String contest, String question, String team_name, String team_leader, String leader_school, String leader_phone, Integer is_award) {
        return teamDao.queryTeam(contest, question, team_name, team_leader, leader_school, leader_phone, is_award);
    }

    @Override
    public boolean addAward(TeamAwardQuery teamAwardQuery) {
        return teamDao.addAward(teamAwardQuery);
    }
}
