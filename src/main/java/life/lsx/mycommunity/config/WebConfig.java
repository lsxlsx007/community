package life.lsx.mycommunity.config;

import life.lsx.mycommunity.interceptor.SessionInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName WebConfig
 * @Description TODO
 * @Author lsx
 * @Date 2019/12/3 11:24
 * @Version 1.0
 */
@Configuration
@Slf4j
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private SessionInterceptor sessionInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("拦截器SessionInterceptor-----------------------------");
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**");
    }
}