package yjp.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import yjp.dao.ExpertDao;
import yjp.pojo.Expert;
import yjp.pojo.MyException;
import yjp.service.ExpertService;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExpertServiceImpl implements ExpertService {

    private final ExpertDao expertDao;

    public ExpertServiceImpl(ExpertDao expertDao) {
        this.expertDao = expertDao;
    }

    @Override
    public List<Expert> listExpert() {
        return expertDao.listExpert();
    }

    @Override
    public boolean addExpert(Expert expert) {
        return expertDao.addExpert(expert);
    }

    @Override
    public boolean deleteExpert(Integer id) {
        return expertDao.deleteExpert(id);
    }

    @Override
    public boolean modifyExpert(Expert expert) {
        return expertDao.modifyExpert(expert);
    }

    @Override
    public boolean emptyRemarks(List<Integer> ids) {
        return expertDao.emptyRemarks(ids);
    }

    @Override
    public boolean modifyRemarks(List<Expert> expertList) {
        return expertDao.modifyRemarks(expertList);
    }

    @Override
    public boolean modifyRemark(Expert expert) {
        return expertDao.modifyRemark(expert);
    }

    @Override
    public List<Expert> queryExpert(Expert expert) {
        return expertDao.queryExpert(expert);
    }

    @Override
    public boolean batchImport(String fileName, MultipartFile file) throws Exception {
        return false;
    }
}
