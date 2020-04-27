package com.csii.webhook.listener;

import com.csii.webhook.filter.SessionFilter;
import lombok.extern.flogger.Flogger;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;
import java.util.Map;
@WebListener
public class RedisListenerConfig implements ServletContextListener {
    private Logger logger = LoggerFactory.getLogger(RedisListenerConfig.class);
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
        Map<String,Object> map =new HashMap<>();

        if (!reslut){
            logger.debug("========================项目连接redis服务异常========================");
        }
    }



    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
