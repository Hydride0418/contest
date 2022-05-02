package yjp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import yjp.pojo.BlockUser;
import yjp.pojo.BlockWork;

@Mapper
@Repository
public interface BlockDao {
    //创建用户 传入封装的user
    public boolean createUser(BlockUser blockUser);
    //资源登记确权 传入封装的work
    public boolean uploadResource(BlockWork blockWork);
    //查询资源 输入资源id 返回作品首发者id
    public Integer queryResource(Integer Id);
}
