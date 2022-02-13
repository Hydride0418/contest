package yjp.controller;

import org.apache.catalina.LifecycleState;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import yjp.pojo.Administrator;
import yjp.pojo.Master_principal;
import yjp.service.MasterPrincipalService;

import java.util.List;

public class MasterPrincipalController {

    private final MasterPrincipalService masterPrincipalService;

    public MasterPrincipalController(MasterPrincipalService masterPrincipalService) {
        this.masterPrincipalService = masterPrincipalService;
    }

    @GetMapping("/query_master")
    @ResponseBody
    public List<Master_principal> queryMaster(@RequestParam("organization_id") String id,
                                           @RequestParam("organization_name") String name) {
        Master_principal master = new Master_principal();
        master.setOrganization_id(id);
        master.setOrganization_name(name);
        return masterPrincipalService.queryMaster(master);
    }

}
