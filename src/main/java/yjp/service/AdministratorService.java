package yjp.service;

import yjp.pojo.Administrator;

import java.util.List;

public interface AdministratorService {
    //返回所有管理员信息
    public List<Administrator> listAdmin();
    //增加一个管理员
    public boolean addAdmin(Administrator administrator);
    //删除一个管理员
    public boolean deleteAdmin(Integer id);
    //修改管理员信息
    public boolean modifyAdmin(Administrator administrator);
}
