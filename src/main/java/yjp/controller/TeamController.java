package yjp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import yjp.pojo.BlockUser;
import yjp.pojo.Question;
import yjp.pojo.Team;
import yjp.pojo.query.SelectionQuery;
import yjp.pojo.query.TeamQuery;
import yjp.service.BlockService;
import yjp.service.TeamService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/team")
public class TeamController {
    private final BlockService blockService;
    private final TeamService teamService;

    public TeamController(TeamService teamService, BlockService blockService) {
        this.teamService = teamService;
        this.blockService = blockService;
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
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        BlockUser blockUser = new BlockUser(team.getId(), team.getName()); //在区块链中创建团队为一个用户
        boolean success1 = blockService.createUser(blockUser);
        return success && success1;
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

    //选题信息批量审核通过
    @PostMapping("/batch_selection_review_pass")
    @ResponseBody
    public boolean batchSelectionReviewPass(@RequestBody List<Integer> idList) {
        boolean success = teamService.batchSelectionReviewPass(idList);
        return success;
    }

    //选题信息批量审核不通过
    @PostMapping("/batch_selection_review_fail")
    @ResponseBody
    public boolean batchSelectionReviewFail(@RequestBody List<Integer> idList) {
        boolean success = teamService.batchSelectionReviewFail(idList);
        return success;
    }

    //选题信息(团队信息+作品信息)查询
    @PostMapping("/search_selection_info")
    @ResponseBody
    public List<Team> searchSelectionInfo(@RequestBody SelectionQuery selectionQuery) {
        List<Team> selectionInfos = teamService.searchSelectionInfo(selectionQuery);
        return selectionInfos;
    }

    //报名信息(团队信息+赛题)查询
    @PostMapping("/search_team_info")
    @ResponseBody
    public List<Question> searchTeamInfo(@RequestBody TeamQuery teamQuery) {
        List<Question> teamInfo = teamService.searchTeamInfo(teamQuery);
        return teamInfo;
    }

    @PostMapping("/upload_work/{id}")
    @ResponseBody
    public String uploadWork(@RequestParam("file") MultipartFile file, @PathVariable("id") Integer teamID) {
        if (file.isEmpty()) {
            return "upload failed";
        }
        String filename = file.getOriginalFilename();
        String filepath = "/Users/bytedance/IdeaProjects/contest1/works"; //作品文件的本地文件夹 未来在服务器中修改
        File dest = new File(filepath + filename);
        try {
            file.transferTo(dest);
            Team team = new Team();
            team.setId(teamID);
            team.setWork_path(filepath + '/' + filename);
            teamService.setWorkPath(team);
            return "upload succeeded";
        } catch (IOException e) {
            System.out.println(e);
        }
        return "upload failed";
    }
}