package yjp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yjp.dao.QuestionDao;
import yjp.pojo.Question;
import yjp.service.QuestionService;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionDao questionDao;

    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public boolean addQuestion(Question question) {
        boolean success = questionDao.addQuestion(question);
        return success;
    }

    @Override
    public List<Question> showQuestionList() {
        List<Question> questionList = questionDao.listQuestion();
        return questionList;
    }

    @Override
    public boolean modifyQuestionInfo(Question question) {
        boolean success = questionDao.modifyQuestion(question);
        return success;
    }

    @Override
    public boolean deleteQuestion(Integer id) {
        boolean success = questionDao.deleteQuestion(id);
        return success;
    }
}
