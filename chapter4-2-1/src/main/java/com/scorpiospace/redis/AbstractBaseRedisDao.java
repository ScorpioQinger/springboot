package com.scorpiospace.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.Resource;

/**
 * @ClassName AbstractBaseRedisDao
 * @Description redis抽象类
 * @Author zq
 * @Date 2019/9/12 14:38
 * @Version 1.0
 **/
public abstract class AbstractBaseRedisDao<K,V> {
    @Resource(name="redisTemplate")
    protected RedisTemplate<K,V> redisTemplate;

    public void setRedisTemplate(RedisTemplate<K,V> redisTemplate)
    {
        this.redisTemplate = redisTemplate;
    }
    protected RedisSerializer<String> getRedisSerializer(){
        return redisTemplate.getStringSerializer();
    }
}
