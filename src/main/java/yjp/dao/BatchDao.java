package yjp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import yjp.pojo.Batch;
import yjp.pojo.query.BatchQuery;

import java.util.List;

@Mapper
@Repository
public interface BatchDao {
    //返回所有批次
    public List<Batch> listBatch();
    //新增批次
    public boolean addBatch(Batch batch);
    //查看批次信息
    public Batch checkBatch(Integer id);
    //查询批次
    public List<Batch> queryBatch(BatchQuery batchQuery);
}
