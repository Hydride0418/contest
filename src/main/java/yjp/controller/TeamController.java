package yjp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yjp.pojo.Team;
import yjp.service.TeamService;

import java.util.List;

@Controller
@RequestMapping("/team")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService ) {
        this.teamService = teamService;
    }

    @GetMapping("/get_list")
    @ResponseBody
    public List<Team> getTeamList(){
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
}
