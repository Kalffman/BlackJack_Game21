package com.kalffman.projects.game21.redis.config;

import com.kalffman.projects.game21.redis.entity.MatchEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import java.util.UUID;

//@EnableRedisRepositories
//@Configuration
public class RedisConfig {

//    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        var conn = new JedisConnectionFactory();
        return conn;
    }


//    @Bean
    public RedisTemplate<?, ?> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        var template = new RedisTemplate<UUID, MatchEntity>();
        template.setConnectionFactory(jedisConnectionFactory);
        return template;
    }
}
