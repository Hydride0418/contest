package yjp.serviceImpl;

import org.springframework.stereotype.Service;
import yjp.dao.TeamDao;
import yjp.pojo.Question;
import yjp.pojo.Team;
import yjp.pojo.query.SelectionQuery;
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
    public boolean batchSelectionReviewPass(List<Integer> idList) {
        boolean success = teamDao.batchSelectionReviewPass(idList);
        return success;
    }

    @Override
    public boolean batchSelectionReviewFail(List<Integer> idList) {
        boolean success = teamDao.batchSelectionReviewFail(idList);
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
}
