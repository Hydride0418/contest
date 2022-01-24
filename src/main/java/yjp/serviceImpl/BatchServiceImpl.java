package yjp.serviceImpl;

import org.springframework.stereotype.Service;
import yjp.dao.BatchDao;
import yjp.pojo.Batch;
import yjp.pojo.query.BatchQuery;
import yjp.service.BatchService;

import java.util.List;

@Service
public class BatchServiceImpl implements BatchService {

    private final BatchDao batchDao;

    public BatchServiceImpl(BatchDao batchDao) {
        this.batchDao = batchDao;
    }

    @Override
    public List<Batch> listBatch() {
        return batchDao.listBatch();
    }

    @Override
    public boolean addBatch(Batch batch) {
        return batchDao.addBatch(batch);
    }

    @Override
    public Batch checkBatch(Integer id) {
        return batchDao.checkBatch(id);
    }

    @Override
    public List<Batch> queryBatch(BatchQuery batchQuery) {
        return batchDao.queryBatch(batchQuery);
    }
}
