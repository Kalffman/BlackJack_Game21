package com.kalffman.projects.game21.redis.config;

import com.kalffman.projects.game21.redis.entity.MatchEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import java.util.UUID;

@EnableRedisRepositories
@Configuration
public class RedisConfig {

    private final String host;
    private final Integer port;
    private final Integer dbIndex;

    public RedisConfig(
            @Value("${redis.host}") String host,
            @Value("${redis.port}") Integer port,
            @Value("${redis.db-index}") Integer dbIndex) {
        this.host = host;
        this.port = port;
        this.dbIndex = dbIndex;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        var config = new RedisStandaloneConfiguration(host, port);
        config.setDatabase(dbIndex);
        return new JedisConnectionFactory(config);
    }

}
