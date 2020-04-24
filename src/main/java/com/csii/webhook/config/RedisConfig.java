package com.csii.webhook.config;

import com.csii.webhook.model.pojo.BusinessQuery;
import com.csii.webhook.model.pojo.TaskQuery;
import com.csii.webhook.model.pojo.TokenEntity;
import com.csii.webhook.model.pojo.Users;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;


import java.net.UnknownHostException;
import java.time.Duration;

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




    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofHours(1)); // 设置缓存有效期一小时
        return RedisCacheManager
                .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
                .cacheDefaults(redisCacheConfiguration).build();
    }




}
