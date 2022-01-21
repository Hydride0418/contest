package yjp.serviceImpl;

import org.springframework.stereotype.Service;
import yjp.dao.ExpertDao;
import yjp.pojo.Expert;
import yjp.service.ExpertService;

import java.util.List;

@Service
public class ExpertServiceImpl implements ExpertService {

    private final ExpertDao expertDao;

    public ExpertServiceImpl(ExpertDao expertDao) {
        this.expertDao = expertDao;
    }

    @Override
    public List<Expert> listExpert() {
        return expertDao.listExpert();
    }

    @Override
    public boolean addExpert(Expert expert) {
        return expertDao.addExpert(expert);
    }

    @Override
    public boolean deleteExpert(Integer id) {
        return expertDao.deleteExpert(id);
    }

    @Override
    public boolean modifyExpert(Expert expert) {
        return expertDao.modifyExpert(expert);
    }

    @Override
    public boolean emptyRemarks(List<Integer> ids) {
        return expertDao.emptyRemarks(ids);
    }

    @Override
    public boolean modifyRemarks(List<Expert> expertList) {
        return expertDao.modifyRemarks(expertList);
    }

    @Override
    public boolean modifyRemark(Expert expert) {
        return expertDao.modifyRemark(expert);
    }
}
