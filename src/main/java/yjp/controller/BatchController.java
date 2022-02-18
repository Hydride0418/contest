package yjp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yjp.pojo.Batch;
import yjp.pojo.query.BatchQuery;
import yjp.response.BatchResponse.AddBatchResponse;
import yjp.service.BatchService;

import java.util.List;

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
    public AddBatchResponse addBatch(@RequestBody Batch batch) {
        AddBatchResponse addBatchResponse = new AddBatchResponse();
        addBatchResponse.generate(batchService.addBatch(batch));
        return addBatchResponse;
    }

    @PostMapping("/query_batch")
    @ResponseBody
    public List<Batch> queryBatch(@RequestBody BatchQuery batchQuery) {
        return batchService.queryBatch(batchQuery);
    }

}
