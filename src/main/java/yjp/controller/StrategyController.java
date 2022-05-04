package yjp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yjp.dao.StrategyDao;
import yjp.pojo.Contest;
import yjp.pojo.Strategy;
import yjp.service.StrategyService;

import java.util.List;

@Controller
@RequestMapping("/strategy")
public class StrategyController {
    private final StrategyService strategyService;

    public StrategyController(StrategyService strategyService) {
        this.strategyService = strategyService;
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Strategy getStrategy(@PathVariable Integer id) {
        System.out.println("getStrategy");
        return strategyService.getStrategy(id);
    }

    @PostMapping("/modify")
    @ResponseBody
    public boolean modifyStrategy(@RequestBody Strategy strategy) {
        System.out.println("modifyStrategy");
        return strategyService.modifyStrategy(strategy);
    }
}
