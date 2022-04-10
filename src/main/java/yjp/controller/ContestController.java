package yjp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import yjp.pojo.Contest;
import yjp.pojo.query.ContestQuery;
import yjp.response.ContestResponse.AddContestResponse;
import yjp.response.ContestResponse.ModifyContestResponse;
import yjp.service.ContestService;

import java.io.File;
import java.io.IOException;
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

    @PostMapping("search")
    @ResponseBody
    public List<Contest> searchContest(@RequestBody ContestQuery contestQuery) {
        List<Contest> contestList = contestService.searchContest(contestQuery);
        return contestList;
    }

    // 上传图片存储 并将图片url绑定至id所对contest
    @PostMapping("/upload_Image/{id}")
    @ResponseBody
    public String uploadImage(@RequestParam("file") MultipartFile file, @PathVariable("id") Integer contestID) {
        if (file.isEmpty()) {
            return "upload failed";
        }
        String filename = file.getOriginalFilename();
        String filepath = "/Users/bytedance/IdeaProjects/contest1/images"; //作品文件的本地文件夹 未来在服务器中修改
        File dest = new File(filepath + filename);
        try {
            file.transferTo(dest);
            Contest contest = new Contest();
            contest.setId(contestID);
            contest.setImage(filepath + filename);
            contestService.setImageUrl(contest);
            return "upload succeeded";
        } catch (IOException e) {
            System.out.println(e);
        }
        return "upload failed";
    }
}
