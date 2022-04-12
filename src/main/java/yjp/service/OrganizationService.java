package yjp.service;

import yjp.pojo.Organization;

import java.util.List;

public interface OrganizationService {
    //返回所有团队
    public List<Organization> listOrg();
    //查询部分机构信息
    public List<Organization> queryOrganization(Organization organization);
}
