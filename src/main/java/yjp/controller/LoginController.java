package yjp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yjp.pojo.Expert;
import yjp.pojo.User;
import yjp.service.ExpertService;
import yjp.service.UserService;
import yjp.util.JwtUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class LoginController {

    private final ExpertService expertService;
    private final UserService userService;

    public LoginController(ExpertService expertService, UserService userService) {
        this.expertService = expertService;
        this.userService = userService;
    }

    @PostMapping(value = "/login")
    public Map<String, Object> login(@RequestBody User sysUser){
        Map<String, Object> map = new HashMap<>();
        String username = sysUser.getUsername();
        String password = userService.getPassword(username);
        Integer id = userService.getUserId(username, password);
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
        // 验证成功后发送token(需要包含role信息)
        String token = JwtUtil.sign(username, password, role);
        if (token != null) {
            map.put("code", "200");
            map.put("message", "认证成功");
            map.put("token", token);
            map.put("role", role);
            map.put("username", username);
            map.put("id", id);
            System.out.println("123");
            System.out.println(id);
            System.out.println("123");
            return map;
        }
        map.put("code", "403");
        map.put("message", "认证失败");
        map.put("role", 0);
        return map;
    }

    @PostMapping(value = "/log_expert")
    public Map<String, Object> loginExpert(@RequestBody Expert sysUser) {
        Map<String, Object> map = new HashMap<>();
        String username = sysUser.getName();
        String password = expertService.getPassword(username);
        System.out.println(password);
        System.out.println(sysUser.getPassword());
        if (!Objects.equals(password, sysUser.getPassword())) {
            map.put("code", "403");
            map.put("message", "密码错误");
            map.put("role", 0);
            return map;
        }
        // 省略 账号密码验证
        // 验证成功后发送token
        Integer id = expertService.getUserId(username, password);
        String token = JwtUtil.sign(username, password, 2);
        if (token != null) {
            map.put("code", "200");
            map.put("message", "认证成功");
            map.put("token", token);
            map.put("role", 2);
            map.put("username", username);
            map.put("id", id);
            return map;
        }
        map.put("code", "403");
        map.put("message", "认证失败");
        map.put("role", 0);
        return map;
    }
}