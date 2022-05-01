package yjp.service;

import yjp.pojo.Allocation;
import yjp.pojo.RuleItem;
import yjp.pojo.query.AllocationQuery;

import java.util.List;

public interface AllocationService {
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
    //查询评阅信息
    public List<Allocation> queryAllocation(AllocationQuery allocationQuery);
    //专家根据自己id查找评阅信息
    public List<Allocation> queryAllByExpId(Integer id, Integer is_valid);
    //提交评阅信息(需要将is_valid设为1)
    public boolean submitReview(Allocation allocation);
    //暂存评阅信息
    public boolean tempSubmit(Allocation allocation);
}
