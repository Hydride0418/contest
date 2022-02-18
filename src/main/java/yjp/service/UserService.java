package yjp.service;

import yjp.pojo.User;

import java.util.List;

public interface UserService {
    // 查询所有用户
    public List<User> listUser();

    //根据id删除用户
    public boolean deleteUserById(Integer id);

    // 根据id查询用户
    public User queryUserById(Integer id);

    // 修改用户
    public boolean updateUser(User user);

    // 新增用户
    public boolean addUser(User user);

}
