package yjp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
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
    public boolean emptyRemarks(@Param("idList") List<Integer> idList);
    //批量修改评阅备注
    public boolean modifyRemarks(@Param("expertList") List<Expert> expertList);
    //修改单个评阅批注
    public boolean modifyRemark(Expert expert);
    //搜索专家
    public List<Expert> queryExpert(Expert expert);
    //查密码
    public String getPassword(String username);

    //查用户角色
    public Integer getUserRole(String username);
}
