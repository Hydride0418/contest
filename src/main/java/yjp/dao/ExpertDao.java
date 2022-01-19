package yjp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import yjp.pojo.Expert;

import java.util.List;

@Mapper
@Repository
public interface ExpertDao {
    //返回所有专家信息
    public List<Expert> listExpert();
    //增加专家
    public boolean addExpert(Expert expert);
    //删除专家
    public boolean deleteExpert(Integer id);
    //修改专家信息
    public boolean modifyExpert(Expert expert);
    //批零清空评阅备注
    public boolean emptyRemarks(List<Integer> ids);
    //批量修改评阅备注
    public boolean modifyRemarks(List<Expert> experts);
    //修改单个评阅批注
    public boolean modifyRemark(Expert expert);
}