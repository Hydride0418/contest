package yjp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import yjp.pojo.Organization;

import java.util.List;

@Mapper
@Repository
public interface OrganizationDao {
    //返回所有团队
    public List<Organization> listOrg();
    //查询部分机构信息
    public List<Organization> queryOrganization(Organization organization);
}
