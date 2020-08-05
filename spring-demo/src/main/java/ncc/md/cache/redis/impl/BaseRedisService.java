package ncc.md.cache.redis.impl;

import ncc.md.cache.redis.RedisPoolFactory;
import ncc.md.cache.redis.itf.IRedisService;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;

/**
 * @author huangbiaof
 * @data 创建时间：2019/9/19 10:23
 */

public abstract class BaseRedisService implements IRedisService {

    private JedisPool jedisPool;


    public BaseRedisService(){
        this.setJedisPool(RedisPoolFactory.getIntance().getJedisPool());
    }

    private void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public JedisPool getJedisPool(){
        return jedisPool;
    }


    public void returnToPool(Jedis jedis) {
        HashMap a = new HashMap();
        if(jedis != null) {

            jedis.close();
        }
    }

}
