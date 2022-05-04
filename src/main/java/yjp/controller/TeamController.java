package yjp.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.apache.poi.ss.formula.ptg.MemAreaPtg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import yjp.pojo.BlockUser;
import yjp.pojo.InviteCode;
import yjp.pojo.Question;
import yjp.pojo.Team;
import yjp.pojo.query.SelectionQuery;
import yjp.pojo.query.TeamQuery;
import yjp.service.BlockService;
import yjp.service.TeamService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/get_workPath")
    @ResponseBody
    public Map<String, String> getWorkPath(@RequestBody Integer id) {
        Map<String, String> res = new HashMap<>();
        res.put("work_path", teamService.getWorkPath(id));
        return res;
    }

    @GetMapping("/get_team_list")
    @ResponseBody
    public List<Team> getTeam2List() {
        return teamService.list2Team();
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public boolean deleteTeam(@PathVariable("id") Integer id) {
        boolean success = teamService.deleteTeam(id);
        return success;
    }

    @PostMapping("/add")
    @ResponseBody
    public Map<String, String> addTeam(@RequestBody Team team) {
        int success = teamService.addTeam(team);
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        BlockUser blockUser = new BlockUser(team.getId(), team.getName()); //在区块链中创建团队为一个用户
        boolean success1 = blockService.createUser(blockUser);
        long id = (long) team.getId();
        System.out.println(id);
        Map<String, String> team_id = new HashMap<>();
        team_id.put("id", String.valueOf(id));
        team_id.put("invite_id", InviteCode.gen(id));
        return team_id;
    }

    //设置一个团队的邀请码
    @GetMapping("/setInviteId")
    @ResponseBody
    public boolean setInviteId(@RequestParam("id") Integer id,
                               @RequestParam("invite_id") String invite_id) {
        return teamService.setInviteId(id, invite_id);
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

    @GetMapping("/query_info") //查询队伍获奖信息
    @ResponseBody
    public List<Team> queryTeam(@RequestParam("contest") String contest,
                                @RequestParam("question") String question,
                                @RequestParam("team_name") String team_name,
                                @RequestParam("team_leader") String team_leader,
                                @RequestParam("leader_school") String leader_school,
                                @RequestParam("leader_phone") String leader_phone,
                                @RequestParam("is_award") Integer is_award) {
        return teamService.queryTeam(contest, question, team_name, team_leader, leader_school, leader_phone, is_award);
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


    @GetMapping("/export")
    @ResponseBody
    public void export(HttpServletResponse response) throws Exception {
        List<Team> list = teamService.showTeamList();
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.addHeaderAlias("name", "队伍名称");
        writer.addHeaderAlias("question.name", "赛题");
        writer.addHeaderAlias("is_award", "是否获奖");
        writer.addHeaderAlias("team_leader", "队长姓名");
        writer.addHeaderAlias("leader_school", "队长所在学校");
        writer.addHeaderAlias("leader_phone", "队长手机号");
        writer.addHeaderAlias("advisor", "指导老师");
        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("参赛队伍获奖情况", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();
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
