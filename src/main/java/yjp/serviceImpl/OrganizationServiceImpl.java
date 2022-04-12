package yjp.serviceImpl;

import org.springframework.stereotype.Service;
import yjp.dao.OrganizationDao;
import yjp.pojo.Organization;
import yjp.service.OrganizationService;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationDao organizationDao;

    public OrganizationServiceImpl(OrganizationDao organizationDao) {
        this.organizationDao = organizationDao;
    }


    @Override
    public List<Organization> listOrg() {
        return organizationDao.listOrg();
    }

    @Override
    public List<Organization> queryOrganization(Organization organization) {
        return organizationDao.queryOrganization(organization);
    }
}
