package yjp.interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import yjp.service.UserService;
import yjp.util.JwtUtil;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    UserService sysUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("!!!!!!!!!!!!!preHandle");
        // 从 http 请求头中取出 token
        String token = request.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        System.out.println("判断token");
        if (token != null) {
            String username = JwtUtil.getUserNameByToken(request);
            System.out.println("username: " + username);
            System.out.println("token " + token);
            // 这边拿到的 用户名 应该去数据库查询获得密码，简略，步骤在service直接获取密码
            System.out.println("password " + sysUserService.getPassword(username));
                boolean result = JwtUtil.verify(token, username, sysUserService.getPassword(username));
                System.out.println("result: " + result);
                if (result) {
                    System.out.println("通过拦截器");
                    return true;
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
