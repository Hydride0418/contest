package yjp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yjp.pojo.Allocation;
import yjp.response.AllocationResponse.AddAllocationResponse;
import yjp.response.AllocationResponse.ModifyAllocationResponse;
import yjp.service.AllocationService;

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

    @GetMapping("/get/{id}")
    @ResponseBody
    public Allocation getAllocationInfo(@PathVariable("id") Integer id) {
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
    public ModifyAllocationResponse modifyAllocation(@RequestBody Allocation allocation) {
        ModifyAllocationResponse modifyAllocationResponse = new ModifyAllocationResponse();
        modifyAllocationResponse.generate(allocationService.backAllocation(allocation));
        return modifyAllocationResponse;
    }
}
