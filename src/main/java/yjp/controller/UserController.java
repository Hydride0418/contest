package yjp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yjp.pojo.User;
import yjp.response.ContestResponse.AddContestResponse;
import yjp.response.ContestResponse.ModifyContestResponse;
import yjp.service.UserService;

import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/query_info") //查询个人获奖信息
    @ResponseBody
    public List<User> queryUser(@RequestParam("contest") String contest,
                                @RequestParam("question") String question,
                                @RequestParam("team_name") String team_name,
                                @RequestParam("user_name") String user_name,
                                @RequestParam("user_school") String user_school,
                                @RequestParam("user_phone") String user_phone,
                                @RequestParam("is_award") Integer is_award) {
        return userService.queryUser(contest, question, team_name, user_name, user_school, user_phone, is_award);
    }

    @GetMapping("/get")
    @ResponseBody
    public List<User> getUserList() {
        return userService.listUser();
    }

    @PostMapping("/add_user")
    @ResponseBody
    public AddContestResponse addUser(@RequestBody User user) {
        boolean success = userService.addUser(user);
        AddContestResponse addContestResponse = new AddContestResponse();
        addContestResponse.generate(success);
        return addContestResponse;
    }

    @PostMapping("/modify_user")
    @ResponseBody
    public ModifyContestResponse modifyUser(@RequestBody User user) {
        boolean success = userService.updateUser(user);
        ModifyContestResponse modifyContestResponse = new ModifyContestResponse();
        modifyContestResponse.generate(success);
        return modifyContestResponse;
    }

    @PostMapping("/get_role")
    @ResponseBody
    public Integer getUserRole(@RequestBody User user) {
        return userService.getUserRole(user.getUsername());
    }
}
