package yjp.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yjp.pojo.User;
import yjp.response.ContestResponse.AddContestResponse;
import yjp.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    @ResponseBody
    public int getUserList() {
        int count = userService.listUser().size();
        System.out.println("**********");
        System.out.println(count);
        return count;
    }

    @PostMapping("/add_user")
    @ResponseBody
    public String addUser(@RequestBody User user) {
        boolean success = userService.addUser(user);
        AddContestResponse addContestResponse = new AddContestResponse();
        addContestResponse.generate(success);
        return JSONObject.toJSONString(addContestResponse);
    }
}
