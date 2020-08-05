package com.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

/**
 * @author huangbiaof
 * @data 创建时间：2019/8/27 16:38
 */

@Repository
public class RedisServiceTemplate {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    public void setKey(String key,String value){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set(key,value);
    }

    public String getKey(String key) {
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();
        return ops.get(key);
    }
}
