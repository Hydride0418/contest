package yjp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yjp.pojo.Award;
import yjp.pojo.query.AwardQuery;
import yjp.response.AwardResponse.AddAwardResponse;
import yjp.response.AwardResponse.DeleteAwardResponse;
import yjp.response.AwardResponse.ModifyAwardResponse;
import yjp.service.AwardService;

import java.util.List;

@Controller
@RequestMapping("/award")
public class AwardController {
    private final AwardService awardService;

    public AwardController(AwardService awardService) {
        this.awardService = awardService;
    }

    @GetMapping("/get")
    @ResponseBody
    public List<Award> getAwardList() {
        List<Award> awardList = awardService.showAwardList();
        return awardList;
    }

    @PostMapping("/add_award")
    @ResponseBody
    public boolean addAward(@RequestBody Award award){
        Integer team_id = award.getTeam_id();
        return awardService.addAward(award) && awardService.addTeamAward(team_id);
    }

    @PostMapping("/add_org_award")
    @ResponseBody
    public boolean addOrgAward(@RequestBody Award award){
        Integer org_id = award.getOrg_id();
        return awardService.addAward(award) && awardService.addOrgAward(org_id);
    }

    @GetMapping("/delete_award/{id}")
    @ResponseBody
    public DeleteAwardResponse deleteAward(@PathVariable("id") Integer id){
        boolean success = awardService.deleteAward(id);
        DeleteAwardResponse deleteAwardResponse = new DeleteAwardResponse();
        deleteAwardResponse.generate(success);
        return deleteAwardResponse;
    }

    @PostMapping("/search_award")
    @ResponseBody
    public List<Award> SearchAward(@RequestBody Integer user_id) {
        return awardService.searchAward(user_id);
    }

    @PostMapping("/modify_award")
    @ResponseBody
    public ModifyAwardResponse modifyAward(@RequestBody Award award){
        boolean success = awardService.modifyAwardInfo(award);
        ModifyAwardResponse modifyAwardResponse = new ModifyAwardResponse();
        modifyAwardResponse.generate(success);
        return modifyAwardResponse;
    }



}
