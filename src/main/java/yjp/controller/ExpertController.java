package yjp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yjp.pojo.Expert;
import yjp.response.ExpertResponse.AddExpertResponse;
import yjp.response.ExpertResponse.DeleteExpertResponse;
import yjp.response.ExpertResponse.ModifyExpertResponse;
import yjp.service.ExpertService;

import java.util.List;

@Controller
@RequestMapping("/expert")
public class ExpertController {

    private final ExpertService expertService;

    public ExpertController(ExpertService expertService) {
        this.expertService = expertService;
    }

    @GetMapping("/get")
    @ResponseBody
    public List<Expert> listExpert() {
        return expertService.listExpert();
    }

    @PostMapping("/add_expert")
    @ResponseBody
    public AddExpertResponse addExpert(@RequestBody Expert expert) {
        AddExpertResponse addExpertResponse = new AddExpertResponse();
        addExpertResponse.generate(expertService.addExpert(expert));
        return addExpertResponse;
    }

    @GetMapping("/delete_expert/{id}")
    @ResponseBody
    public DeleteExpertResponse deleteExpert(@PathVariable("id") Integer id) {
        DeleteExpertResponse deleteExpertResponse = new DeleteExpertResponse();
        deleteExpertResponse.generate(expertService.deleteExpert(id));
        return deleteExpertResponse;
    }

    @PostMapping("/modify_expert")
    @ResponseBody
    public ModifyExpertResponse modifyExpert(@RequestBody Expert expert) {
        ModifyExpertResponse modifyExpertResponse = new ModifyExpertResponse();
        modifyExpertResponse.generate(expertService.modifyExpert(expert));
        return modifyExpertResponse;
    }

}
