package yjp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yjp.pojo.User;
import yjp.service.UserService;
import yjp.util.JwtUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/login")
    public Map<String, Object> login(@RequestBody User sysUser) {
        Map<String, Object> map = new HashMap<>();
        String username = sysUser.getUsername();
        String password = userService.getPassword(username);
        System.out.println(password);
        System.out.println(sysUser.getPassword());
        if(!Objects.equals(password, sysUser.getPassword())) {
            map.put("code", "403");
            map.put("message", "密码错误");
            map.put("role", 0);
            return map;
        }
        Integer role = userService.getUserRole(username);
        // 省略 账号密码验证
        // 验证成功后发送token
        String token = JwtUtil.sign(username, password);
        if (token != null) {
            map.put("code", "200");
            map.put("message", "认证成功");
            map.put("token", token);
            map.put("role", role);
            return map;
        }
        map.put("code", "403");
        map.put("message", "认证失败");
        map.put("role", 0);
        return map;
    }
}