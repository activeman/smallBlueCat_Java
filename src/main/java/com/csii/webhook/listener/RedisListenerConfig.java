package com.csii.webhook.listener;

import com.csii.webhook.filter.SessionFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;
import java.util.Map;

@WebListener
public class RedisListenerConfig implements ServletContextListener {
    @Value("${spring.redis.host}")
    private String url;

    @Value("${spring.redis.port}")
    private int  port;

    @Value("${spring.redis.password}")
    private String  password;



    @Override
    public void contextInitialized(ServletContextEvent sce) {
        boolean reslut =false;
        reslut =  SessionFilter.getRedisResult(url,port,password);
//        Map<String,Object> map =new HashMap<>();
//
//        if (reslut==false){
//
//        }
    }



    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
