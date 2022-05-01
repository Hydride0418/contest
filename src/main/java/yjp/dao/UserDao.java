package yjp.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    //根据id查用户报名信息（先根据用户查对应teamId，再查team对应的ques的id、name）
    public List<User> queryQuesById(Integer id);

    //根据team_id查对应的用户
    public List<User> queryMem(Integer team_id);

    //根据id删除用户
    public int deleteUserById(Integer id);

    //设置团队id
    public boolean setTeam(@Param("id") Integer id,
                           @Param("team_id") Integer team_id);

    // 修改用户
    public int updateUser(User user);

    // 新增用户
    public int addUser(User user);

    //查密码
    public String getPassword(String username);

    //修改密码
    public boolean setPassword(String password, Integer id);

    //搜索用户信息
    public List<User> queryUser(@Param("contest") String contest,
                                @Param("question") String question,
                                @Param("team_name") String team_name,
                                @Param("user_name") String user_name,
                                @Param("user_school") String user_school,
                                @Param("user_phone") String user_phone,
                                @Param("is_award") Integer is_award);

    //查用户角色
    public Integer getUserRole(String username);
    //根据用户用户名和密码查找用户id
    public Integer getUserId(String username, String password);
}

