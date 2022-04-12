package yjp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import yjp.pojo.Allocation;
import yjp.pojo.RuleItem;
import yjp.pojo.query.AllocationQuery;

import java.util.List;

@Mapper
@Repository
public interface AllocationDao {
    //返回所有评审信息
    public List<Allocation> listAllocation();
    //查看单个作品评审信息
    public List<Allocation> listWorkAllocation(Integer id);
    //退回评审信息,置为无效
    public boolean backAllocation(Integer id);
    //查看评阅信息
    public List<RuleItem> checkAllocation(Integer id);
    //增加评阅信息
    public boolean addAllocation(Allocation allocation);
    //查阅评阅信息
    public List<Allocation> queryAllocation(AllocationQuery allocationQuery);
}
