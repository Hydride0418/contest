package yjp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yjp.dao.BlockDao;
import yjp.pojo.BlockUser;
import yjp.pojo.BlockWork;
import yjp.service.BlockService;

@Service
public class BlockServiceImpl implements BlockService {
    private final BlockDao blockDao;

    public BlockServiceImpl(BlockDao blockDao) {
        this.blockDao = blockDao;
    }

    @Override
    public boolean createUser(BlockUser blockUser) {
        return blockDao.createUser(blockUser);
    }

    @Override
    public boolean uploadResource(BlockWork blockWork) {
        return blockDao.uploadResource(blockWork);
    }

    @Override
    public Integer queryResource(Integer id) {
        return blockDao.queryResource(id);
    }
}
