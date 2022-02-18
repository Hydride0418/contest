package yjp.service;

import yjp.pojo.Administrator;

import java.util.List;

public interface AdministratorService {
    //返回所有管理员信息
    public List<Administrator> listAdmin();
    //增加一个管理员或修改管理员信息
    public boolean saveAdmin(Administrator administrator);
    //删除一个管理员
    public boolean deleteAdmin(Integer id);
<<<<<<< HEAD
//    //修改管理员信息
//    public boolean modifyAdmin(Administrator administrator);
    //分页查询管理员
    public List<Administrator> queryAdmin(String name, String organization, String phone, Integer pageNum, Integer pageSize);
    //查询管理员信息总数
    public List<Administrator> queryNum(String name, String organization, String phone);
=======
    //修改管理员信息
    public boolean modifyAdmin(Administrator administrator);
    //查询管理员
    public List<Administrator> queryAdmin(Administrator administrator);
>>>>>>> 18ba691fabe248fe72b0d4a06072744a9f8d57fc
}
