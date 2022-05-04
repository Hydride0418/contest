package yjp.service;

import yjp.pojo.Batch;
import yjp.pojo.query.BatchQuery;

import java.util.List;

public interface BatchService {
    //返回所有批次
    public List<Batch> listBatch();
    //新增批次
    public Integer addBatch(Batch batch);
    //查看批次信息
    public Batch checkBatch(Integer id);
    //查询批次
    public List<Batch> queryBatch(BatchQuery batchQuery);
}
