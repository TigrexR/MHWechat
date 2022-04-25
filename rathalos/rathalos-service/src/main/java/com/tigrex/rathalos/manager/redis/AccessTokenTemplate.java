package com.tigrex.rathalos.manager.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tigrex.rathalos.entity.wechat.AccessToken;
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
@Repository(value = "accessTokenRedisTemplate")
public class AccessTokenTemplate extends AbstractRedisTemplate<AccessToken> implements InitializingBean {

    @Override
    @Bean(value = "accessTokenRedisCacheManager")
    public CacheManager cacheManager() {
        Jackson2JsonRedisSerializer<AccessToken> serializer = getSerializer();
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .disableCachingNullValues().entryTtl(Duration.ofSeconds(7200L))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer));
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);
        return new RedisCacheManager(redisCacheWriter, cacheConfiguration);
    }

    @Override
    public void afterPropertiesSet() {
        Jackson2JsonRedisSerializer<AccessToken> serializer = getSerializer();
        setConnectionFactory(redisConnectionFactory);
        setKeySerializer(new StringRedisSerializer());
        setValueSerializer(serializer);
        setHashKeySerializer(new StringRedisSerializer());
        setHashValueSerializer(serializer);
        super.afterPropertiesSet();
    }

    @Override
    public Jackson2JsonRedisSerializer<AccessToken> getSerializer() {
        Jackson2JsonRedisSerializer<AccessToken> serializer = new Jackson2JsonRedisSerializer<>(AccessToken.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        serializer.setObjectMapper(objectMapper);
        return serializer;
    }
}
