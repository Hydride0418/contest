package yjp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import yjp.pojo.Allocation;

import java.util.List;

@Mapper
@Repository
public interface AllocationDao {
    //返回所有评审信息
    public List<Allocation> listAllocation();
    //退回评审信息,置为无效
    public boolean backAllocation(Allocation allocation);
    //查看评阅信息
    public Allocation checkAllocation(Integer id);
}
