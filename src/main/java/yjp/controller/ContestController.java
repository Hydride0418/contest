package yjp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yjp.pojo.Contest;
import yjp.pojo.query.ContestQuery;
import yjp.response.ContestResponse.AddContestResponse;
import yjp.response.ContestResponse.ModifyContestResponse;
import yjp.service.ContestService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/contest")
public class ContestController {
    private final ContestService contestService;

    public ContestController(ContestService contestService) {
        this.contestService = contestService;
    }

    @GetMapping("/get")
    @ResponseBody
    public List<Contest> getUserList() {
        List<Contest> contestList = contestService.showContestList();
        return contestList;
    }

    @PostMapping("/add_contest")
    @ResponseBody
    public AddContestResponse addContest(@RequestBody Contest contest) {
        boolean success = contestService.addContest(contest);
        AddContestResponse addContestResponse = new AddContestResponse();
        addContestResponse.generate(success);
        return addContestResponse;
    }

    @PostMapping("/modify_contest")
    @ResponseBody
    public ModifyContestResponse modifyContest(@RequestBody Contest contest) {
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
        String filepath = "D:/resources/Agraduation/city-front - 2/vuetest/src/Json"; //作品文件的本地文件夹 未来在服务器中修改
        File f = new File(filepath);
        File[] fs = f.listFiles();
       outputStream.write(Files.readAllBytes(Paths.get(filepath).resolve(fs[0].getName())));

        outputStream.flush();
        outputStream.close();
    }

}
