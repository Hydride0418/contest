package yjp.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yjp.pojo.Expert;
import yjp.response.ExpertResponse.*;
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

    @PostMapping("/empty_remarks")
    @ResponseBody
    public EmptyRemarksResponse emptyRemarks(@RequestBody List<Integer> idList) {
        EmptyRemarksResponse emptyRemarksResponse = new EmptyRemarksResponse();
        emptyRemarksResponse.generate(expertService.emptyRemarks(idList));
        return emptyRemarksResponse;
    }

    @PostMapping("/modify_expert")
    @ResponseBody
    public ModifyExpertResponse modifyExpert(@RequestBody Expert expert) {
        ModifyExpertResponse modifyExpertResponse = new ModifyExpertResponse();
        modifyExpertResponse.generate(expertService.modifyExpert(expert));
        return modifyExpertResponse;
    }

    @PostMapping("/modify_remark")
    @ResponseBody
    public ModifyRemarkResponse modifyRemark(@RequestBody Expert expert) {
        ModifyRemarkResponse modifyRemarkResponse = new ModifyRemarkResponse();
        modifyRemarkResponse.generate(expertService.modifyRemark(expert));
        return modifyRemarkResponse;
    }

    @PostMapping("/modify_remarks")
    @ResponseBody
    public ModifyRemarksResponse modifyRemarks(@RequestBody List<Expert> expertList) {
        ModifyRemarksResponse modifyRemarksResponse = new ModifyRemarksResponse();
        modifyRemarksResponse.generate(expertService.modifyRemarks(expertList));
        return modifyRemarksResponse;
    }

    @GetMapping("/query_expert")
    @ResponseBody
    public List<Expert> queryExpert(@RequestParam("name") String name,
                                    @RequestParam("organization_name") String organization_name,
                                    @RequestParam("major_name") String major_name,
                                    @RequestParam("phone") String phone,
                                    @RequestParam("research_direction") String research_direction,
                                    @RequestParam("remarks") String remarks) {
        Expert expert = new Expert();
        expert.setName(name);
        expert.setOrganization_name(organization_name);
        expert.setMajor_name(major_name);
        expert.setResearch_direction(research_direction);
        expert.setRemarks(remarks);
        return expertService.queryExpert(expert);
    }

}
