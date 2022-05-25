package yjp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import yjp.pojo.Contest;
import yjp.pojo.Strategy;
import yjp.pojo.Team;
import yjp.pojo.query.ContestQuery;
import yjp.response.ContestResponse.AddContestResponse;
import yjp.response.ContestResponse.ModifyContestResponse;
import yjp.service.ContestService;
import yjp.service.StrategyService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@Controller
@RequestMapping("/contest")
public class ContestController {
    private final ContestService contestService;
    private final StrategyService strategyService;

    public ContestController(ContestService contestService, StrategyService strategyService) {
        this.contestService = contestService;
        this.strategyService = strategyService;
    }

    @GetMapping("/get")
    @ResponseBody
    public List<Contest> getContestList() {
        List<Contest> contestList = contestService.showContestList();
        return contestList;
    }

    @GetMapping("/get_contest/{id}")
    @ResponseBody
    public Contest getContest(@PathVariable("id") Integer id) {
        Contest contest = contestService.getContest(id);
        return contest;
    }

    @PostMapping("/add_contest")
    @ResponseBody
    public AddContestResponse addContest(@RequestBody Contest contest) {
        System.out.println(contest.getStart_time());
        boolean success = contestService.addContest(contest);
        AddContestResponse addContestResponse = new AddContestResponse();
        addContestResponse.generate(success);
        return addContestResponse;
    }

    @PostMapping("/modify_contest")
    @ResponseBody
    public ModifyContestResponse modifyContest(@RequestBody Contest contest) {
        System.out.println(contest.getStart_time());
        boolean success = contestService.modifyContestInfo(contest);
        ModifyContestResponse modifyContestResponse = new ModifyContestResponse();
        modifyContestResponse.generate(success);
        return modifyContestResponse;
    }

    @PostMapping("/search")
    @ResponseBody
    public List<Contest> searchContest(@RequestBody ContestQuery contestQuery) {
        List<Contest> contestList = contestService.searchContest(contestQuery);
        return contestList;
    }

    @GetMapping("/getJson")
    @ResponseBody
    public void getJson(HttpServletResponse response) throws IOException {
        ServletOutputStream outputStream = response.getOutputStream();
        String filepath = "/Users/bytedance/city_front/city_front/src/Json"; //作品文件的本地文件夹 未来在服务器中修改
        File f = new File(filepath);
        File[] fs = f.listFiles();
        assert fs != null;
        outputStream.write(Files.readAllBytes(Paths.get(filepath).resolve(fs[0].getName())));

        outputStream.flush();
        outputStream.close();
    }
}
