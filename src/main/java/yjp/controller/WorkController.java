package yjp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yjp.pojo.Work;
import yjp.pojo.query.ReviewQuery;
import yjp.service.WorkService;

import java.util.List;

@RequestMapping("/work")
@Controller
public class WorkController {
    private final WorkService workService;

    public WorkController(WorkService workService ) {
        this.workService = workService;
    }

    @GetMapping("/get_list")
    @ResponseBody
    public List<Work> getWorkList(){
        List<Work> workList = workService.showWorkList();
        return workList;
    }

    @GetMapping("/get_reviewed_info")
    @ResponseBody
    public List<Work> getWorkInfo() {
        return workService.showInfo();
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public boolean deleteWork(@PathVariable("id") Integer id) {
        boolean success = workService.deleteWork(id);
        return success;
    }

    @PostMapping("/add")
    @ResponseBody
    public boolean addWork(@RequestBody Work work) {
        boolean success = workService.addWork(work);
        return success;
    }

    @PostMapping("/modify")
    @ResponseBody
    public boolean modifyWork(@RequestBody Work work) {
        boolean success = workService.modifyWorkInfo(work);
        return success;
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Work getWorkInfo(@PathVariable("id") Integer id) {
        Work work = workService.getWorkById(id);
        return work;
    }

    @PostMapping("/search_review")
    @ResponseBody
    public List<Work> searchReview(@RequestBody ReviewQuery reviewQuery) {
        return workService.queryReview(reviewQuery);
    }

}
