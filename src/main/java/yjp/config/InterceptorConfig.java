package yjp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import yjp.interceptor.JwtInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /* *
     * @Author lsc
     * <p> 设置拦截路径 </p>
     * @Param [registry]
     * @Return void
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor())
                .excludePathPatterns("/**");
//                .excludePathPatterns("/login")
//                .excludePathPatterns("/work/getImage/**")
//                .excludePathPatterns("/user/**")
//                .excludePathPatterns("/work/modify") //for test
//                .excludePathPatterns("/work/like/**")
//                .excludePathPatterns("/work/revert_like/**")
//                .excludePathPatterns("/work/get/**")
//                .excludePathPatterns("/work/get_list")
//                .excludePathPatterns("/contest/get_contest/**")
//                .excludePathPatterns("/contest/get")
//                .excludePathPatterns("/contest/search")
//                .excludePathPatterns("/contest/add_contest") // test
//                .excludePathPatterns("/contest/modify_contest") // for test
//                .excludePathPatterns("/question/get") // for test
//                .excludePathPatterns("/question/add") // for test
//                .excludePathPatterns("/expert/**")
//                .excludePathPatterns("/log_expert");
    }

    /* *
     * @Author lsc
     * <p> 将拦截器注入context </p>
     * @Param []
     * @Return com.zszxz.jwt.interceptor.JwtInterceptor
     */
    @Bean
    public JwtInterceptor authenticationInterceptor() {
        return new JwtInterceptor();
    }

    /* *
     * @Author lsc
     * <p>跨域支持 </p>
     * @Param [registry]
     * @Return void
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH", "OPTIONS", "HEAD")
                .maxAge(3600 * 24);
    }
}
