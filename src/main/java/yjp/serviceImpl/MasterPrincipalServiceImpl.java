package yjp.serviceImpl;

import yjp.dao.MasterprincipalDao;
import yjp.pojo.Master_principal;
import yjp.service.MasterPrincipalService;

import java.util.List;

public class MasterPrincipalServiceImpl implements MasterPrincipalService {

    private final MasterprincipalDao masterprincipalDao;

    public MasterPrincipalServiceImpl(MasterprincipalDao masterprincipalDao) {
        this.masterprincipalDao = masterprincipalDao;
    }

    @Override
    public List<Master_principal> queryMaster(Master_principal master) {
        return masterprincipalDao.queryMaster(master);
    }
}
