package yjp.service;

import yjp.pojo.Administrator;

import java.util.List;

public interface AdministratorService {

    // 查询所有管理员
    public List<Administrator> listAdministrator();

    // 新增管理员
    public  boolean addAdministrator(Administrator administrator);

    // 修改管理员信息
    public boolean updateAdministrator(Administrator administrator);

    // 修改管理员密码
    public boolean modifyAdministratorPassword(Administrator administrator);

}
