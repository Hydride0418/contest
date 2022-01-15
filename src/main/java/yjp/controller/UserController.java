package yjp.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import yjp.pojo.User;
import yjp.response.AddUserResponse;
import yjp.service.UserService;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

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
        return JSONObject.toJSONString(AddUserResponse.genAddUserResponse(success));
    }
}
