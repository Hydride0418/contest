package yjp.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yjp.pojo.Expert;
import yjp.pojo.Question;
import yjp.pojo.Team;
import yjp.pojo.query.SelectionQuery;
import yjp.pojo.query.TeamAwardQuery;
import yjp.pojo.query.TeamQuery;
import yjp.service.TeamService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//    //团队新增奖项
//    @PostMapping("/add_award")
//    @ResponseBody
//    public boolean addTeamAward(@RequestBody TeamAwardQuery teamAwardQuery) {
//        return teamService.addAward(teamAwardQuery);
//    }

    //查看审核历史（需要新增 审核信息 实体）
}
