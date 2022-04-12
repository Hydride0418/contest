package yjp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import yjp.pojo.Master_principal;

import java.util.List;

@Mapper
@Repository
public interface MasterprincipalDao {
    //查询研究生培养负责人
    public List<Master_principal> queryMaster(Master_principal master);
}
