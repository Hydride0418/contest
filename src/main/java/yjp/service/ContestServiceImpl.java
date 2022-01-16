package yjp.service;

import org.springframework.stereotype.Service;
import yjp.dao.ContestDao;
import yjp.pojo.Contest;
import yjp.pojo.query.ContestQuery;

import java.util.List;

@Service
public class ContestServiceImpl implements ContestService{
    private final ContestDao contestDao;

    public ContestServiceImpl(ContestDao contestDao) {
        this.contestDao = contestDao;
    }

    @Override
    public boolean addContest(Contest contest) {
        boolean success = contestDao.addContest(contest);
        return success;
    }

    @Override
    public List<Contest> showContestList() {
        List<Contest> contestList = contestDao.listContest();
        return contestList;
    }

    @Override
    public List<Contest> searchContest(ContestQuery contestQuery) {
        return null;
    }

    @Override
    public boolean modifyContestInfo(Contest contest) {
        boolean success = contestDao.modifyContest(contest);
        return success;
    }
}
