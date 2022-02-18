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
    public boolean saveAdmin(Administrator administrator) {
        if (administrator.getId() == null) {
            return administratorDao.addAdmin(administrator);
        } else {
            return administratorDao.modifyAdmin(administrator);
        }
    }

    @Override
    public boolean deleteAdmin(Integer id) {
        return administratorDao.deleteAdmin(id);
    }

//    @Override
//    public boolean modifyAdmin(Administrator administrator) {
//        return administratorDao.modifyAdmin(administrator);
//    }

    @Override
    public List<Administrator> queryAdmin(String name, String organization, String phone, Integer pageNum, Integer pageSize) {
        return administratorDao.queryAdmin(name, organization, phone, pageNum, pageSize);
    }

    @Override
    public List<Administrator> queryNum(String name, String organization, String phone) {
        return administratorDao.queryNum(name, organization, phone);
    }

<<<<<<< HEAD
//    @Override
//    public List<Administrator> selectPage(Integer pageNum, Integer pageSize) {
//        return administratorDao.selectPage(pageNum, pageSize);
//    }
=======
    @Override
    public List<Administrator> queryAdmin(Administrator administrator) {
        return administratorDao.queryAdmin(administrator);
    }
>>>>>>> 18ba691fabe248fe72b0d4a06072744a9f8d57fc

}
