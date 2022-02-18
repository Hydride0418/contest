package yjp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import yjp.pojo.Administrator;

import java.util.List;

@Mapper
@Repository
public interface AdministratorDao {
    //返回所有管理员信息
    public List<Administrator> listAdmin();
    //增加一个管理员
    public boolean addAdmin(Administrator administrator);
    //删除一个管理员
    public boolean deleteAdmin(Integer id);
    //修改管理员信息
    public boolean modifyAdmin(Administrator administrator);
<<<<<<< HEAD
    //分页查询管理员
    public List<Administrator> queryAdmin(@Param("name") String name, @Param("organization") String organization,
                                          @Param("phone") String phone, @Param("pageNum") Integer pageNum,
                                          @Param("pageSize") Integer pageSize);
    //查询管理员信息总数
    public List<Administrator> queryNum(@Param("name") String name, @Param("organization") String organization,
                                        @Param("phone") String phone);
=======
    //查询管理员
    public List<Administrator> queryAdmin(Administrator administrator);
>>>>>>> 18ba691fabe248fe72b0d4a06072744a9f8d57fc
}
