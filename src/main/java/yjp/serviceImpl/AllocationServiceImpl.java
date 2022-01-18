package yjp.serviceImpl;

import org.springframework.stereotype.Service;
import yjp.dao.AllocationDao;
import yjp.pojo.Allocation;
import yjp.service.AllocationService;

import java.util.List;

@Service
public class AllocationServiceImpl implements AllocationService {

    private final AllocationDao allocationDao;

    public AllocationServiceImpl(AllocationDao allocationDao) {
        this.allocationDao = allocationDao;
    }

    @Override
    public List<Allocation> listAllocation() {
        return allocationDao.listAllocation();
    }

    @Override
    public boolean backAllocation(Allocation allocation) {
        return allocationDao.backAllocation(allocation);
    }

    @Override
    public Allocation checkAllocation(Integer id) {
        return allocationDao.checkAllocation(id);
    }
}
