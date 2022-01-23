package yjp.service;

import yjp.pojo.Master_principal;

import java.util.List;

public interface MasterPrincipalService {
    //查询研究生培养负责人
    public List<Master_principal> queryMaster(Master_principal master);
}
