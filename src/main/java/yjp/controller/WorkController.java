package yjp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import yjp.pojo.BlockWork;
import yjp.pojo.Strategy;
import yjp.pojo.Work;
import yjp.pojo.WorkIncident;
import yjp.pojo.query.ReviewQuery;
import yjp.service.BlockService;
import yjp.service.StrategyService;
import yjp.service.WorkService;
import yjp.util.ConvUtil;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

//@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping("/work")
@Controller
public class WorkController {
    private final BlockService blockService;
    private final WorkService workService;
    private final StrategyService strategyService;

    public WorkController(WorkService workService, BlockService blockService, StrategyService strategyService) {
        this.workService = workService;
        this.blockService = blockService;
        this.strategyService = strategyService;
    }

    @GetMapping("/get_list")
    @ResponseBody
    public List<Work> getWorkList() {
        List<Work> workList = workService.showWorkList();
        Strategy s = strategyService.getStrategy(1);
        if (Objects.equals(s.getWork_strategy(), "按热度")) {
            Collections.sort(workList, new Comparator<Work>() {
                @Override
                public int compare(Work o1, Work o2) {
                    int diff = o1.getLikes() - o2.getLikes();
                    if (diff < 0) {
                        return 1;
                    } else if (diff > 0) {
                        return -1;
                    }
                    return 0;
                }
            });
        }
        return workList;
    }

    @GetMapping("/trace_progress/{id}")
    @ResponseBody
    public List<WorkIncident> traceProgress(@PathVariable("id") Integer id) {
        List<WorkIncident> progressList = workService.getWorkIncident(id);
        Collections.sort(progressList, new Comparator<WorkIncident>() {
            @Override
            public int compare(WorkIncident o1, WorkIncident o2) {
                Integer diff = o1.getTime().compareTo(o2.getTime());
                if (diff > 0) {
                    return 1;
                } else if (diff < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
//        if(Objects.equals(s.getWork_strategy(), "按热度")) {
//            Collections.sort(workList,new Comparator<Work>() {
//                @Override
//                public int compare(Work o1, Work o2) {
//                    int diff = o1.getLikes() - o2.getLikes();
//                    if (diff < 0) {
//                        return 1;
//                    } else if (diff > 0) {
//                        return -1;
//                    }
//                    return 0;
//                }
//            });
//        }
        return progressList;
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

    @PostMapping("/add_progress")
    @ResponseBody
    public boolean addProgress(@RequestBody WorkIncident workIncident) {
        System.out.println(workIncident.getTime());
        boolean success = workService.addWorkIncident(workIncident);
        return success;
    }

    @PostMapping("/modify")
    @ResponseBody
    public boolean modifyWork(@RequestBody Work work) {
        boolean success = workService.modifyWorkInfo(work);
        return success;
    }

    @GetMapping("/set_workExp")
    @ResponseBody
    public boolean setWorkExp(@RequestParam("id") Integer id,
                              @RequestParam("work_expert") Integer work_expert) {
        return workService.setWorkExp(id, work_expert);
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
        return workService.queryReview(reviewQuery);
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

    @PostMapping("/add_Review")
    @ResponseBody
    public boolean addReview(@RequestBody Integer id) {
        return workService.addReviewed(id);
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

    @GetMapping("/download")
    public String downloadFile(HttpServletResponse response, @RequestParam("fileName") String fileName) {
        if (fileName != null) {
            //设置文件路径
            File file = new File("/Users/bytedance/IdeaProjects/contest1/images/1.jpg"); //用了一个本地路径来测试
//            File file = new File(realPath , fileName); 这里的realPath填写文件的真实路径即可
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    return "下载成功";
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return "下载失败";
    }
}
