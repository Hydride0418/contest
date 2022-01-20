package yjp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import yjp.pojo.Administrator;
import java.util.List;

@Mapper
@Repository
public interface AdministratorDao {

    // 查询所有管理员
    public List<Administrator> listAdministrator();

    // 新增管理员
    public  boolean addAdministrator(Administrator administrator);
    // 修改管理员信息
    public boolean updateAdministrator(Administrator administrator);

    // 修改管理员密码
    int modifyAdministratorPassword(@Param("administrator") Administrator administrator, @Param("password") String password);

}
