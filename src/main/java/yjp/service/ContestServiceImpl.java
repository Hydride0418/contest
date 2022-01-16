package yjp.service;

import org.springframework.beans.factory.annotation.Autowired;
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
        return false;
    }

    @Override
    public List<Contest> showContestList() {
        return null;
    }

    @Override
    public List<Contest> searchContest(ContestQuery contestQuery) {
        return null;
    }

    @Override
    public boolean modifyContestInfo(Contest contest) {
        return false;
    }
}
