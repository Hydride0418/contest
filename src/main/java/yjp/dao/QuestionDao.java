package yjp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import yjp.pojo.Question;

import java.util.List;

@Mapper
@Repository
public interface QuestionDao {
    //返回所有赛题
    public List<Question> listQuestion();
    //增加一个赛题
    public boolean addQuestion(Question question);
    //根据id删除一个赛题
    public boolean deleteQuestion(Integer id);
    //修改赛题信息
    public boolean modifyQuestion(Question Question);
}
