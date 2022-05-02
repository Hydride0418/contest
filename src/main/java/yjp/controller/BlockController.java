package yjp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yjp.pojo.Allocation;
import yjp.pojo.BlockUser;
import yjp.pojo.BlockWork;
import yjp.pojo.Contest;
import yjp.response.ContestResponse.AddContestResponse;
import yjp.service.BlockService;

import java.util.List;

@Controller
@RequestMapping("/block")
public class BlockController {
    private final BlockService blockService;

    public BlockController(BlockService blockService) {
        this.blockService = blockService;
    }

    @PostMapping("/create_user")
    @ResponseBody
    public boolean createUser(@RequestBody BlockUser blockUser) {
        boolean success = blockService.createUser(blockUser);
        return success;
    }

    @PostMapping("/upload_resource")
    @ResponseBody
    public boolean uploadResource(@RequestBody BlockWork blockWork) {
        boolean success = blockService.uploadResource(blockWork);
        return success;
    }

    @GetMapping("/query_owner/{id}")
    @ResponseBody
    public Integer queryOwner(@PathVariable("id") Integer id) {
        return blockService.queryResource(id);
    }
}
