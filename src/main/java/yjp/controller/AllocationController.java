package yjp.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yjp.pojo.Allocation;
import yjp.pojo.RuleItem;
import yjp.pojo.query.AllocationQuery;
import yjp.response.AllocationResponse.AddAllocationResponse;
import yjp.response.AllocationResponse.ModifyAllocationResponse;
import yjp.service.AllocationService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/allocation")
public class AllocationController {
    private final AllocationService allocationService;

    public AllocationController(AllocationService allocationService) {
        this.allocationService = allocationService;
    }

    @GetMapping("/get")
    @ResponseBody
    public List<Allocation> listAllocation() {
        return allocationService.listAllocation();
    }

    @GetMapping("/get_info/{id}")
    @ResponseBody
    public List<Allocation> getWorkAllocation(@PathVariable("id") Integer id) {
        return allocationService.listWorkAllocation(id);
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public List<RuleItem> getAllocationInfo(@PathVariable("id") Integer id) {
        return allocationService.checkAllocation(id);
    }

    @PostMapping("/add_allocation")
    @ResponseBody
    public AddAllocationResponse addAllocationResponse(@RequestBody Allocation allocation) {
        AddAllocationResponse addAllocationResponse = new AddAllocationResponse();
        addAllocationResponse.generate(allocationService.addAllocation(allocation));
        return addAllocationResponse;
    }

    //退回
    @PostMapping("/back")
    @ResponseBody
    public ModifyAllocationResponse modifyAllocation(@RequestBody Integer id) {
        ModifyAllocationResponse modifyAllocationResponse = new ModifyAllocationResponse();
        modifyAllocationResponse.generate(allocationService.backAllocation(id));
        return modifyAllocationResponse;
    }

    //查询
    @PostMapping("/query_allocation")
    @ResponseBody
    public List<Allocation> queryAllocation(@RequestBody AllocationQuery allocationQuery) {
        return allocationService.queryAllocation(allocationQuery);
    }

    @GetMapping("/export")
    @ResponseBody
    public void export(HttpServletResponse response) throws Exception {
        List<Allocation> list = allocationService.listAllocation();
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.addHeaderAlias("team_id", "队伍序号");
        writer.addHeaderAlias("expert_id", "专家序号");
        writer.addHeaderAlias("masks", "各项评分");
        writer.addHeaderAlias("sum", "总分");
        writer.addHeaderAlias("advice", "建议");
        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("评阅信息", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();
    }

    @GetMapping("/queryById")
    @ResponseBody
    public List<Allocation> queryAllByExpId(@RequestParam("expert_id") Integer expert_id,
                                            @RequestParam("is_valid") Integer is_valid) {
        System.out.println(is_valid);
        return allocationService.queryAllByExpId(expert_id, is_valid);
    }

    @PostMapping("/submit")
    @ResponseBody
    public boolean submit(@RequestBody Allocation allocation) {
        return allocationService.submitReview(allocation);
    }

    @PostMapping("/tempSubmit")
    @ResponseBody
    public boolean tempSubmit(@RequestBody Allocation allocation) {
        return allocationService.tempSubmit(allocation);
    }

}
