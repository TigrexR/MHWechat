package com.tigrex.mh.manager.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tigrex.mh.entity.bo.SystemUserBO;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;

import java.time.Duration;

/**
 * redis template
 * @author linus
 */
@Repository(value = "systemUserRedisTemplate")
public class SystemUserTemplate extends AbstractRedisTemplate<SystemUserBO> implements InitializingBean {

    @Override
    @Bean(value = "systemUserRedisCacheManager")
    public CacheManager cacheManager() {
        Jackson2JsonRedisSerializer<SystemUserBO> serializer = getSerializer();
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .disableCachingNullValues().entryTtl(Duration.ofSeconds(3600L))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer));
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);
        return new RedisCacheManager(redisCacheWriter, cacheConfiguration);
    }

    @Override
    public void afterPropertiesSet() {
        Jackson2JsonRedisSerializer<SystemUserBO> serializer = getSerializer();
        setConnectionFactory(redisConnectionFactory);
        setKeySerializer(new StringRedisSerializer());
        setValueSerializer(serializer);
        setHashKeySerializer(new StringRedisSerializer());
        setHashValueSerializer(serializer);
        super.afterPropertiesSet();
    }

    @Override
    public Jackson2JsonRedisSerializer<SystemUserBO> getSerializer() {
        Jackson2JsonRedisSerializer<SystemUserBO> serializer = new Jackson2JsonRedisSerializer<>(SystemUserBO.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        serializer.setObjectMapper(objectMapper);
        return serializer;
    }
}
