package yjp.service;

import yjp.pojo.Batch;

import java.util.List;

public interface BatchService {
    //返回所有批次
    public List<Batch> listBatch();
    //新增批次
    public boolean addBatch(Batch batch);
    //查看批次信息
    public Batch checkBatch(Integer id);
}
