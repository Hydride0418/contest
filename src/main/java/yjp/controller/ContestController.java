package yjp.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yjp.pojo.Contest;
import yjp.response.ContestResponse.AddContestResponse;
import yjp.response.ContestResponse.ModifyContestResponse;
import yjp.service.ContestService;

@Controller
@RequestMapping("/contest")
public class ContestController {
    private final ContestService contestService;

    public ContestController(ContestService contestService) {
        this.contestService = contestService;
    }

    @GetMapping("/get")
    @ResponseBody
    public int getUserList() {
        int count = contestService.showContestList().size();
        System.out.println(count);
        return count;
    }

    @PostMapping("/add_contest")
    @ResponseBody
    public String addContest(@RequestBody Contest contest) {
        boolean success = contestService.addContest(contest);
        AddContestResponse addContestResponse = new AddContestResponse();
        addContestResponse.generate(success);
        return JSONObject.toJSONString(addContestResponse);
    }

    @PostMapping("/modify_contest")
    @ResponseBody
    public String modifyContest(@RequestBody Contest contest) {
        boolean success = contestService.modifyContestInfo(contest);
        ModifyContestResponse modifyContestResponse = new ModifyContestResponse();
        modifyContestResponse.generate(success);
        return JSONObject.toJSONString(modifyContestResponse);
    }
}
