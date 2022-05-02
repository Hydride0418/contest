package yjp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import yjp.pojo.BlockWork;
import yjp.pojo.Work;
import yjp.pojo.query.ReviewQuery;
import yjp.service.BlockService;
import yjp.service.WorkService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Logger;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping("/work")
@Controller
public class WorkController {
    private final BlockService blockService;
    private final WorkService workService;

    public WorkController(WorkService workService, BlockService blockService) {
        this.workService = workService;
        this.blockService = blockService;
    }

    @GetMapping("/get_list")
    @ResponseBody
    public List<Work> getWorkList() {
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

    @PostMapping("/set_block_id")
    @ResponseBody
    public boolean setBlockID(@RequestBody Work work) {
        boolean success = workService.setBlockID(work);
        return success;
    }

    @GetMapping("/like/{id}")
    @ResponseBody
    public boolean likeWork(@PathVariable("id") Integer id) {
        boolean success = workService.likeWork(id);
        return success;
    }

    @GetMapping("/revert_like/{id}")
    @ResponseBody
    public boolean revertLikeWork(@PathVariable("id") Integer id) {
        boolean success = workService.revertLikeWork(id);
        return success;
    }

    @PostMapping("/add")
    @ResponseBody
    public boolean addWork(@RequestBody Work work) {
        boolean success = workService.addWork(work);
        //这里work_id通过mybatis自动设置为数据库自增id的值了
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = tempDate.format(new java.util.Date());
        BlockWork blockWork = new BlockWork(work.getId(), work.getWork_path(), work.getTeam_id(), datetime);
        boolean success1 = blockService.uploadResource(blockWork);
        return success && success1;
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
        System.out.println(id);
        Work work = workService.getWorkById(id);
        return work;
    }

    @PostMapping("/search_review")
    @ResponseBody
    public List<Work> searchReview(@RequestBody ReviewQuery reviewQuery) {
        return workService.showWorkList();
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "upload failed";
        }
        String filename = file.getOriginalFilename();
        String filepath = "/Users/bytedance/IdeaProjects/contest1/works"; //作品文件的本地文件夹 未来在服务器中修改
        File dest = new File(filepath + filename);
        try {
            file.transferTo(dest);
            return "upload succeeded";
        } catch (IOException e) {
            System.out.println(e);
        }
        return "upload failed";
    }

    @GetMapping("/getImage/{id}")
    public void getImage(HttpServletResponse response, @PathVariable("id") Integer id) throws IOException {
        ServletOutputStream outputStream = response.getOutputStream();
        String filepath = "/Users/bytedance/IdeaProjects/contest1/images"; //作品文件的本地文件夹 未来在服务器中修改
        File f = new File(filepath);
        File[] fs = f.listFiles();

        if (id < fs.length && id != 0 && !fs[id].isDirectory()) { //id为0 会抓到一个.DS_Store的文件
            System.out.println("id is " + id);
            System.out.println("name is " + fs[id].getName());
            outputStream.write(Files.readAllBytes(Paths.get(filepath).resolve(fs[id].getName())));
        }

        outputStream.flush();
        outputStream.close();
    }
}
