package yjp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yjp.pojo.*;
import yjp.response.ContestResponse.AddContestResponse;
import yjp.service.BlockService;
import yjp.service.TeamService;

import java.io.PrintStream;
import java.util.List;

@Controller
@RequestMapping("/block")
public class BlockController {
    private final TeamService teamService;
    private final BlockService blockService;

    public BlockController(BlockService blockService, TeamService teamService) {
        this.blockService = blockService;
        this.teamService = teamService;
    }

    @PostMapping("/create_user")
    @ResponseBody
    public boolean createUser(@RequestBody BlockUser blockUser) {
        boolean success = blockService.createUser(blockUser);
        return success;
    }

    @PostMapping("/upload_resource")
    @ResponseBody
    public boolean uploadResource(@RequestBody BlockWork blockWork) {
        boolean success = blockService.uploadResource(blockWork);
        return success;
    }

    @GetMapping("/query_owner/{id}")
    @ResponseBody
    public Team queryOwner(@PathVariable("id") Integer id) {
        Integer teamID =  blockService.queryResource(id);
        Team team = teamService.getTeamById(teamID);
        return team;
    }
}
