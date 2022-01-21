package yjp.service;

import yjp.pojo.Allocation;

import java.util.List;

public interface AllocationService {
    //返回所有评审信息
    public List<Allocation> listAllocation();
    //退回评审信息,置为无效
    public boolean backAllocation(Allocation allocation);
    //查看评阅信息
    public Allocation checkAllocation(Integer id);
    //增加评阅信息
    public boolean addAllocation(Allocation allocation);
}
