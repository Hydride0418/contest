package yjp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yjp.pojo.PreContest;
import yjp.response.PreContestResponse.AddPreContestResponse;
import yjp.response.PreContestResponse.DeletePreContestResponse;
import yjp.response.PreContestResponse.ModifyPreContestResponse;
import yjp.service.PreContestService;

import java.util.List;

@Controller
@RequestMapping("/pre_contest")
public class PreContestController {
    private final PreContestService preContestService;

    public PreContestController(PreContestService preContestService) {
        this.preContestService = preContestService;
    }

    @GetMapping("/get")
    @ResponseBody
    public List<PreContest> getPreContestList() {
        List<PreContest> preContestList = preContestService.showPreContestList();
        return preContestList;
    }

    @PostMapping("/add_pre_contest")
    @ResponseBody
    public AddPreContestResponse addPreContest(@RequestBody PreContest preContest) {
        boolean success = preContestService.addPreContest(preContest);
        AddPreContestResponse addPreContestResponse = new AddPreContestResponse();
        addPreContestResponse.generate(success);
        return addPreContestResponse;
    }

    @GetMapping("/delete_pre_contest/{id}")
    @ResponseBody
    public DeletePreContestResponse deletePreContest(@PathVariable("id") Integer id){
        boolean success = preContestService.deletePreContest(id);
        DeletePreContestResponse deletePreContestResponse = new DeletePreContestResponse();
        deletePreContestResponse.generate(success);
        return deletePreContestResponse;
    }

    @PostMapping("/modify_pre_contest")
    @ResponseBody
    public ModifyPreContestResponse modifyPreContest(@RequestBody PreContest preContest) {
        boolean success = preContestService.modifyPreContestInfo(preContest);
        ModifyPreContestResponse modifyPreContestResponse = new ModifyPreContestResponse();
        modifyPreContestResponse.generate(success);
        return modifyPreContestResponse;
    }
}
