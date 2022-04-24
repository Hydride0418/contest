package yjp.serviceImpl;

import org.springframework.stereotype.Service;
import yjp.dao.UserDao;
import yjp.pojo.User;
import yjp.service.UserService;

import java.util.List;

@Service   //  交由spring容器管理
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> listUser() {
        return userDao.listUser();
    }

    @Override
    public boolean deleteUserById(Integer id) {
        int i = userDao.deleteUserById(id);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User queryUserById(Integer id) {
        return userDao.queryUserById(id);
    }

    @Override
    public boolean updateUser(User user) {
        int i = userDao.updateUser(user);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user) > 0;
    }

    @Override
    public String getPassword(String username) {
        return userDao.getPassword(username);
    }

    @Override
    public List<User> queryUser(String contest, String question, String team_name, String user_name, String user_school, String user_phone, Integer is_award) {
        return userDao.queryUser(contest, question, team_name, user_name, user_school, user_phone, is_award);
    }

    @Override
    public Integer getUserRole(String username) {
        return userDao.getUserRole(username);
    }

}
