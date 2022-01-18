package yjp.service;

import yjp.pojo.Question;

import java.util.List;

public interface QuestionService {
    //新增赛题
    public boolean addQuestion(Question question);
    //分页展示赛题列表
    public List<Question> showQuestionList();
    //修改赛题信息
    public boolean modifyQuestionInfo(Question question);
    //删除赛题
    public boolean deleteQuestion(Integer id);
}
