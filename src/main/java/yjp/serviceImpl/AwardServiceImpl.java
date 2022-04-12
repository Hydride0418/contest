package yjp.serviceImpl;

import org.springframework.stereotype.Service;
import yjp.dao.AwardDao;
import yjp.pojo.Award;
import yjp.pojo.query.AwardQuery;
import yjp.service.AwardService;

import java.util.List;

@Service
public class AwardServiceImpl implements AwardService {
    private final AwardDao awardDao;

    public AwardServiceImpl(AwardDao awardDao) {
        this.awardDao = awardDao;
    }

    @Override
    public boolean addAward(Award award) {
        boolean success = awardDao.addAward(award);
        return success;
    }

    @Override
    public boolean deleteAward(Integer id) {
        boolean success = awardDao.deleteAward(id);
        return success;
    }

    @Override
    public List<Award> showAwardList() {
        List<Award> awardList = awardDao.listAward();
        return awardList;
    }

    @Override
    public List<Award> searchAward(AwardQuery awardQuery) {
        return awardDao.searchAward(awardQuery);
    }

    @Override
    public boolean modifyAwardInfo(Award award) {
        boolean success = awardDao.modifyAward(award);
        return success;
    }

    @Override
    public boolean addTeamAward(Integer team_id) {
        return awardDao.addTeamAward(team_id);
    }

    @Override
    public boolean addOrgAward(Integer org_id) {
        return awardDao.addOrgAward(org_id);
    }


}
