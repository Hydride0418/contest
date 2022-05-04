package yjp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yjp.pojo.InviteCode;
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

    @GetMapping("/get_user")
    @ResponseBody
    public User getUserById(@RequestParam("id") Integer id) {
        return userService.queryUserById(id);
    }

    @GetMapping("/setPass")
    @ResponseBody
    public boolean setPass(@RequestParam String password,
                           @RequestParam Integer id) {
        return userService.setPassword(password, id);
    }

    @GetMapping("/setTeam")
    @ResponseBody
    public boolean setTeam(@RequestParam("id") Integer id,
                           @RequestParam("invite_id") String invite_id) {
        long team_id = InviteCode.decode(invite_id);
        return userService.setTeam(id, (int) team_id);
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

    @GetMapping("/get_userId")
    @ResponseBody
    public Integer getUserId(@RequestParam("username") String username,
                             @RequestParam("password") String password) {
        return userService.getUserId(username, password);
    }

    @PostMapping("/get_ques")
    @ResponseBody
    public List<User> getQues(@RequestBody Integer id) {
        return userService.queryQuesById(id);
    }

    @PostMapping("/get_mem")
    @ResponseBody
    public List<User> getMem(@RequestBody Integer team_id) {
        return userService.queryMem(team_id);
    }
}
