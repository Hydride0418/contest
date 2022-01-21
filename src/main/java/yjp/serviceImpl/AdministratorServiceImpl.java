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
    public List<Administrator> listAdmin() {
        return administratorDao.listAdmin();
    }

    @Override
    public boolean addAdmin(Administrator administrator) {
        return administratorDao.addAdmin(administrator);
    }

    @Override
    public boolean deleteAdmin(Integer id) {
        return administratorDao.deleteAdmin(id);
    }

    @Override
    public boolean modifyAdmin(Administrator administrator) {
        return administratorDao.modifyAdmin(administrator);
    }
}
