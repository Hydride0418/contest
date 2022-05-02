package yjp.serviceImpl;

import org.springframework.stereotype.Service;
import yjp.dao.WorkDao;
import yjp.pojo.Work;
import yjp.pojo.query.ReviewQuery;
import yjp.service.WorkService;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {
    private final WorkDao workDao;

    public WorkServiceImpl(WorkDao workDao) {
        this.workDao = workDao;
    }

    @Override
    public boolean addWork(Work work) {
        boolean success =  workDao.addWork(work);
        return success;
    }

    @Override
    public List<Work> showWorkList() {
        List<Work> workList = workDao.listWork();
        return workList;
    }

    @Override
    public boolean modifyWorkInfo(Work work) {
        boolean success = workDao.modifyWork(work);
        return success;
    }

    @Override
    public boolean deleteWork(Integer id) {
        boolean success = workDao.deleteWork(id);
        return success;
    }

    @Override
    public Work getWorkById(Integer id) {
        Work work = workDao.getWorkById(id);
        return work;
    }

    @Override
    public List<Work> showInfo() {
        return workDao.listInfo();
    }

    @Override
    public List<Work> queryReview(ReviewQuery reviewQuery) {
        return workDao.queryReview(reviewQuery);
    }

    @Override
    public boolean setBlockID(Work work) {
        return workDao.setBlockID(work);
    }

    @Override
    public boolean likeWork(Integer id) {
        return workDao.likeWork(id);
    }

    @Override
    public boolean revertLikeWork(Integer id) {
        return workDao.revertLikeWork(id);
    }
}
