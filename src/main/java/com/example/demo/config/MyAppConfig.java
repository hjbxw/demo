package com.example.demo.config;

import com.example.demo.component.LoginHandlerInterceptor;
import com.example.demo.service.HelloService;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;
import java.io.Serializable;

/*
 * @Configuration 指明当前类是一个配置类，就是来代替之前的Spring配置文件
 * */
@Configuration
public class MyAppConfig implements WebMvcConfigurer {

    //    注册拦截器，未登录拦截
    //spring boot做好了静态资源映射
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/main.html");
//                .excludePathPatterns("/index.html","/","/user/login","/static/**");
    }

    //   注册静态资源
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //需要配置1：----------- 需要告知系统，这是要被当成静态文件的！
        //第一个方法设置访问路径前缀，第二个方法设置资源路径
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/").addResourceLocations("file:///E:/fileUpload/");
/*
        registry.addResourceHandler("/fileupload/**").addResourceLocations("file:///E:/fileUpload/");
*/
    }

    /*将方法的返回值添加到容器中，容器中的这个组件默认的id就是方法名*/
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        登录页面
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
//        首页
        registry.addViewController("/main.html").setViewName("home");
        registry.addViewController("/register.html").setViewName("register");
        registry.addViewController("/setpwd.html").setViewName("setpwd");
    }


    /**
     * 序列化配置
     */
    @Bean
    public RedisTemplate<String, Serializable> redisTemplate
    (LettuceConnectionFactory redisConnectionFactory) {
       // LOGGER.info("RedisConfig == >> redisTemplate ");
        RedisTemplate<String, Serializable> template = new RedisTemplate<>();
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }


}
