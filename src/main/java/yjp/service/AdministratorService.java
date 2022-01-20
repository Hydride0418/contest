package yjp.service;

import yjp.pojo.Administrator;

import java.util.List;
import org.apache.ibatis.annotations.Results;

public interface AdministratorService {

    // 查询所有管理员
    public List<Administrator> listAdministrator();

    // 新增管理员
    public  boolean addAdministrator(Administrator administrator);

    // 修改管理员信息
    public boolean updateAdministrator(Administrator administrator);

    // 修改管理员密码
    public boolean modifyAdministratorPassword(Administrator administrator, String newPassword);

}
