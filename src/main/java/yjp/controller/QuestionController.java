package yjp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yjp.pojo.Question;
import yjp.response.QuestionResponse.AddQuestionResponse;
import yjp.response.QuestionResponse.DeleteQuestionResponse;
import yjp.response.QuestionResponse.ModifyQuestionResponse;
import yjp.service.QuestionService;

import java.util.List;

@RequestMapping("/question")
@Controller
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/get")
    @ResponseBody
    public List<Question> getQuestionList() {
        List<Question> questionList = questionService.showQuestionList();
        return questionList;
    }

    @PostMapping("/add")
    @ResponseBody
    public AddQuestionResponse addQuestion(@RequestBody Question question) {
        boolean success = questionService.addQuestion(question);
        AddQuestionResponse addQuestionResponse = new AddQuestionResponse();
        addQuestionResponse.generate(success);
        return addQuestionResponse;
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public DeleteQuestionResponse deleteQuestion(@PathVariable("id") Integer id){
        boolean success = questionService.deleteQuestion(id);
        DeleteQuestionResponse deleteQuestionResponse = new DeleteQuestionResponse();
        deleteQuestionResponse.generate(success);
        return deleteQuestionResponse;
    }

    @PostMapping("/modify")
    @ResponseBody
    public ModifyQuestionResponse modifyQuestion(@RequestBody Question question) {
        boolean success = questionService.modifyQuestionInfo(question);
        ModifyQuestionResponse modifyQuestionResponse = new ModifyQuestionResponse();
        modifyQuestionResponse.generate(success);
        return modifyQuestionResponse;
    }
}
