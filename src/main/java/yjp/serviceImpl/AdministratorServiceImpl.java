package yjp.serviceImpl;

import org.springframework.stereotype.Service;
import yjp.dao.AdministratorDao;
import yjp.pojo.Administrator;
import yjp.service.AdministratorService;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {
    private final AdministratorDao administratorDao;


    public AdministratorServiceImpl(AdministratorDao administratorDao) {
        this.administratorDao = administratorDao;
    }

    @Override
    public List<Administrator> listAdministrator() {
        return null;
    }

    @Override
    public boolean addAdministrator(Administrator administrator) {
        return false;
    }

    @Override
    public boolean updateAdministrator(Administrator administrator) {
        return false;
    }

    @Override
    public boolean modifyAdministratorPassword(Administrator administrator, String newPassword) {
        administratorDao.modifyAdministratorPassword(administrator, newPassword);
        return true;
    }

}
