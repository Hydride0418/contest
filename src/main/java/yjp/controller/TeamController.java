package yjp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yjp.pojo.Question;
import yjp.pojo.Team;
import yjp.pojo.query.SelectionQuery;
import yjp.pojo.query.TeamQuery;
import yjp.service.TeamService;

import java.util.List;

@Controller
@RequestMapping("/team")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/get_list")
    @ResponseBody
    public List<Team> getTeamList() {
        List<Team> teamList = teamService.showTeamList();
        return teamList;
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public boolean deleteTeam(@PathVariable("id") Integer id) {
        boolean success = teamService.deleteTeam(id);
        return success;
    }

    @PostMapping("/add")
    @ResponseBody
    public boolean addTeam(@RequestBody Team team) {
        boolean success = teamService.addTeam(team);
        return success;
    }

    @PostMapping("/modify")
    @ResponseBody
    public boolean modifyTeam(@RequestBody Team team) {
        boolean success = teamService.modifyTeamInfo(team);
        return success;
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Team getTeamInfo(@PathVariable("id") Integer id) {
        Team team = teamService.getTeamById(id);
        return team;
    }

    //参赛资格审核
    @GetMapping("/qualification_review")
    @ResponseBody
    public boolean qualificationReview(@PathVariable("id") Integer id) {
        boolean success = teamService.qualificationReview(id);
        return false;
    }

    //选题信息批量审核
    @PostMapping("/batch_selection_review")
    @ResponseBody
    public boolean batchSelectionReview(@RequestBody List<Integer> idList) {
        System.out.println(idList.get(1));
        boolean success = teamService.batchSelectionReview(idList);
        return success;
    }

    //选题信息(团队信息+作品信息)查询
    @PostMapping("/search_selection_info")
    @ResponseBody
    public List<Team> searchSelectionInfo(@RequestBody SelectionQuery selectionQuery) {
        List<Team> selectionInfos =  teamService.searchSelectionInfo(selectionQuery);
        return selectionInfos;
    }

    //报名信息(团队信息+赛题)查询
    @PostMapping("/search_team_info")
    @ResponseBody
    public List<Question> searchTeamInfo(@RequestBody TeamQuery teamQuery) {
        List<Question> teamInfo = teamService.searchTeamInfo(teamQuery);
        return teamInfo;
    }

    //查看审核历史（需要新增 审核信息 实体）
}
