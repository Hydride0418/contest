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
    public List<User> queryMem(Integer team_id) {
        return userDao.queryMem(team_id);
    }

    @Override
    public List<User> queryQuesById(Integer id) {
        return userDao.queryQuesById(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean setTeam(Integer id, Integer team_id) {
        return userDao.setTeam(id, team_id);
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
    public boolean setPassword(String password, Integer id) {
        return userDao.setPassword(password, id);
    }

    @Override
    public List<User> queryUser(String contest, String question, String team_name, String user_name, String user_school, String user_phone, Integer is_award) {
        return userDao.queryUser(contest, question, team_name, user_name, user_school, user_phone, is_award);
    }

    @Override
    public Integer getUserRole(String username) {
        return userDao.getUserRole(username);
    }

    @Override
    public Integer getUserId(String username, String password) {
        return userDao.getUserId(username, password);
    }

}
