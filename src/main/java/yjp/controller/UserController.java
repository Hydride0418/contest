package yjp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yjp.pojo.Allocation;
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

    @GetMapping("/get")
    @ResponseBody
    public List<User> getUserList() {
        return userService.listUser();
    }

    @PostMapping("/get_role")
    @ResponseBody
    public Integer getUserRole(@RequestBody User user) {
        return userService.getUserRole(user.getUsername());
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
}
