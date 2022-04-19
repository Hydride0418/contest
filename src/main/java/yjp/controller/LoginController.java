package yjp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yjp.pojo.User;
import yjp.util.JwtUtil;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @PostMapping(value = "/login")
    public Map<String, Object> login(@RequestBody User sysUser){
        Map<String, Object> map = new HashMap<>();
        String username = sysUser.getUsername();
        String password = sysUser.getPassword();
        // 省略 账号密码验证
        // 验证成功后发送token
        String token = JwtUtil.sign(username,password);
        if (token != null){
            map.put("code", "200");
            map.put("message","认证成功");
            map.put("token", token);
            return map;
        }
        map.put("code", "403");
        map.put("message","认证失败");
        return map;
    }
}