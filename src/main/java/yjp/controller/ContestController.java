package yjp.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yjp.pojo.Contest;
import yjp.response.ContestResponse.AddContestResponse;
import yjp.service.ContestService;

@Controller
@RequestMapping("/contest")
public class ContestController {
    private final ContestService contestService;

    public ContestController(ContestService contestService) {
        this.contestService = contestService;
    }

    @PostMapping("/add_contest")
    @ResponseBody
    public String addContest(@RequestBody Contest contest) {
        boolean success = contestService.addContest(contest);
        AddContestResponse addContestResponse = new AddContestResponse();
        addContestResponse.generate(success);
        return JSONObject.toJSONString(addContestResponse);
    }
}
