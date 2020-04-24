package com.csii.webhook.config;

import com.csii.webhook.model.pojo.BusinessQuery;
import com.csii.webhook.model.pojo.TaskQuery;
import com.csii.webhook.model.pojo.TokenEntity;
import com.csii.webhook.model.pojo.Users;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<Object, Users> userRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Users> template = new RedisTemplate<Object, Users>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Users> ser = new Jackson2JsonRedisSerializer<Users>(Users.class);
        template.setDefaultSerializer(ser);
        return template;
    }
    @Bean
    public RedisTemplate<Object, TokenEntity> tokenRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, TokenEntity> template = new RedisTemplate<Object, TokenEntity>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<TokenEntity> ser = new Jackson2JsonRedisSerializer<TokenEntity>(TokenEntity.class);
        template.setDefaultSerializer(ser);
        return template;
    }

    @Bean
    public RedisTemplate<String, BusinessQuery> businessQueryRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<String, BusinessQuery> template = new RedisTemplate<String, BusinessQuery>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<BusinessQuery> ser = new Jackson2JsonRedisSerializer<BusinessQuery>(BusinessQuery.class);
        template.setDefaultSerializer(ser);
        return template;
    }


//    //CacheManagerCustomizers可以来定制缓存的一些规则
//    @Primary  //将某个缓存管理器作为默认的
//    @Bean
//    public RedisCacheManager employeeCacheManager(RedisTemplate<Object, Employee> empRedisTemplate){
//        RedisCacheManager cacheManager = new RedisCacheManager(empRedisTemplate);
//        //key多了一个前缀
//
//        //使用前缀，默认会将CacheName作为key的前缀
//        cacheManager.setUsePrefix(true);
//
//        return cacheManager;
//    }

//    @Bean
//    public RedisCacheManager deptCacheManager(RedisTemplate<Object, Department> deptRedisTemplate){
//        RedisCacheManager cacheManager = new RedisCacheManager(deptRedisTemplate);
//        //key多了一个前缀
//
//        //使用前缀，默认会将CacheName作为key的前缀
//        cacheManager.setUsePrefix(true);
//
//        return cacheManager;
//    }

}
