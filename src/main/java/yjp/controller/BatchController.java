package yjp.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yjp.pojo.Administrator;
import yjp.pojo.Batch;
import yjp.pojo.query.BatchQuery;
import yjp.response.BatchResponse.AddBatchResponse;
import yjp.service.BatchService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/batch")
public class BatchController {

    private final BatchService batchService;

    public BatchController(BatchService batchService) {
        this.batchService = batchService;
    }

    @GetMapping("/get")
    @ResponseBody
    public List<Batch> listBatch() {
        return batchService.listBatch();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Batch getBatchInfo(@PathVariable("id") Integer id) {
        return batchService.checkBatch(id);
    }

    @PostMapping("/add_batch")
    @ResponseBody
    public Map<String, Integer> addBatch(@RequestBody Batch batch) {
        Map<String, Integer> res = new HashMap<>();
        int tag = batchService.addBatch(batch);
        int temp = batch.getId();
        if (tag > 0) {
            res.put("code", 200);
            res.put("batch_id", temp);
        } else {
            res.put("code", 600);
        }
        return res;
    }

    @PostMapping("/query_batch")
    @ResponseBody
    public List<Batch> queryBatch(@RequestBody BatchQuery batchQuery) {
        return batchService.queryBatch(batchQuery);
    }

    @GetMapping("/export")
    @ResponseBody
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<Batch> list = batchService.listBatch();
        // 通过工具类创建writer 写出到磁盘路径
//        ExcelWriter writer = ExcelUtil.getWriter(filesUploadPath + "/用户信息.xlsx");
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);
        //自定义标题别名
        writer.addHeaderAlias("name", "批次名称");
//        writer.addHeaderAlias("rule.name", "评审指标");
//        writer.addHeaderAlias("contest.name", "赛事名称");
        writer.addHeaderAlias("work_expert", "作品评审专家数量");
        writer.addHeaderAlias("expert_work", "专家评审作品数量");
        writer.addHeaderAlias("start_date", "评审开始时间");
        writer.addHeaderAlias("end_date", "评审截止时间");
        writer.addHeaderAlias("is_aveg", "是否去除最大最小成绩");
        writer.addHeaderAlias("is_max", "是否只取最大成绩");

        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("评审批次信息", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();
    }

}
