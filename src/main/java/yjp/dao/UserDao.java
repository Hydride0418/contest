package yjp.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import yjp.pojo.User;

import java.util.List;

@Mapper  // 告诉springboot这是一个mybatis的mapper类
@Repository   // 将userDao交由spring容器管理
public interface UserDao {
    // 查询所有用户
    public List<User> listUser();

    // 根据id查询用户
    public User queryUserById(Integer id);

    //根据id删除用户
    public int deleteUserById(Integer id);

    // 修改用户
    public int updateUser(User user);

    // 新增用户
    public int addUser(User user);

    //根据
}

