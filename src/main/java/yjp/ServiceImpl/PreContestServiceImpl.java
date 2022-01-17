package yjp.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import yjp.dao.PreContestDao;
import yjp.pojo.PreContest;
import yjp.service.PreContestService;

import java.util.List;

@Service
public class PreContestServiceImpl implements PreContestService {
    private final PreContestDao preContestDao;

    public PreContestServiceImpl(PreContestDao preContestDao) {
        this.preContestDao = preContestDao;
    }

    @Override
    public boolean addPreContest(PreContest preContest) {
        boolean success = preContestDao.addPreContest(preContest);
        return success;
    }

    @Override
    public boolean deletePreContest(Integer id) {
        boolean success = preContestDao.deletePreContest(id);
        return success;
    }

    @Override
    public List<PreContest> showPreContestList() {
        List<PreContest> preContestList = preContestDao.listPreContest();
        return preContestList;
    }

    @Override
    public boolean modifyPreContestInfo(PreContest preContest) {
        boolean success = preContestDao.modifyPreContest(preContest);
        return success;
    }
}
