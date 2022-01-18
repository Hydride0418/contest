package yjp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import yjp.pojo.Work;

import java.util.List;

@Mapper
@Repository
public interface WorkDao {
    //返回所有作品
    public List<Work> listWork();
    //增加一个作品
    public boolean addWork(Work work);
    //根据id删除一个作品
    public boolean deleteWork(Integer id);
    //修改作品信息
    public boolean modifyWork(Work Work);
    //根据id查一个作品的信息
    public Work getWorkById(Integer id);
}
