package yjp.service;

import yjp.pojo.Work;
import yjp.pojo.query.ReviewQuery;

import java.util.List;

public interface WorkService {
    //新增作品
    public boolean addWork(Work work);
    //分页展示作品列表
    public List<Work> showWorkList();
    //修改作品信息
    public boolean modifyWorkInfo(Work work);
    //删除作品
    public boolean deleteWork(Integer id);
    //根据id查一个作品的信息
    public Work getWorkById(Integer id);
    //展示评审结果信息
    public List<Work> showInfo();
    //搜索评审结果
    public List<Work> queryReview(ReviewQuery reviewQuery);
    //设置评审专家数
    public boolean setWorkExp(Integer id, Integer work_expert);
    //将reviewed_num加1
    public boolean addReviewed(Integer id);
}
