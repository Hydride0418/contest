package yjp.serviceImpl;

import org.springframework.stereotype.Service;
import yjp.dao.AllocationDao;
import yjp.pojo.Allocation;
import yjp.pojo.RuleItem;
import yjp.pojo.query.AllocationQuery;
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
    public List<Allocation> listWorkAllocation(Integer id) {
        return allocationDao.listWorkAllocation(id);
    }

    @Override
    public boolean backAllocation(Integer allocation) {
        return allocationDao.backAllocation(allocation);
    }

    @Override
    public List<RuleItem> checkAllocation(Integer id) {
        return allocationDao.checkAllocation(id);
    }

    @Override
    public boolean addAllocation(Allocation allocation) {
        return allocationDao.addAllocation(allocation);
    }

    @Override
    public List<Allocation> queryAllocation(AllocationQuery allocationQuery) {
        return allocationDao.queryAllocation(allocationQuery);
    }

    @Override
    public List<Allocation> queryAllByExpId(Integer id, Integer is_valid) {
        return allocationDao.queryAllByExpId(id, is_valid);
    }

    @Override
    public boolean submitReview(Allocation allocation) {
        return allocationDao.submitReview(allocation);
    }

    @Override
    public boolean tempSubmit(Allocation allocation) {
        return allocationDao.tempSubmit(allocation);
    }
}
