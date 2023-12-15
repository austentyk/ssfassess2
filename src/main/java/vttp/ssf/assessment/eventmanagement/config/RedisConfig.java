package vttp.ssf.assessment.eventmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


import org.springframework.beans.factory.annotation.Value;
import vttp.ssf.assessment.eventmanagement.models.Event;

@Configuration
public class RedisConfig {


    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private Integer redisPort;

    @Value("${spring.redis.username}")
    private String redisUsername;

    @Value("${spring.redis.password}")
    private String redisPassword;

    @Bean
    public JedisConnectionFactory jedisConnFactory() {

        RedisStandaloneConfiguration rsc = new RedisStandaloneConfiguration(redisHost, redisPort);

        if (redisUsername != null && !redisUsername.isEmpty()) {
            rsc.setUsername(redisUsername);
        }

        if (redisPassword != null && !redisPassword.isEmpty()) {
            rsc.setPassword(redisPassword);
        }

        JedisClientConfiguration jedisClient = JedisClientConfiguration.builder().build();
        JedisConnectionFactory jedisFac = new JedisConnectionFactory(rsc, jedisClient);
        jedisFac.afterPropertiesSet();

        return jedisFac;
    }


    @Bean("eventTemp")
    public RedisTemplate<String, Event> EventTemplate() {
        RedisTemplate<String, Event> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

    
}
