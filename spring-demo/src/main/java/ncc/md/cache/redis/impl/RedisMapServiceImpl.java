package ncc.md.cache.redis.impl;

import ncc.md.cache.redis.prefix.KeyPrefix;
import ncc.md.cache.redis.utils.JsonTranslateUtil;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ncc.md.cache.redis.utils.JsonTranslateUtil.JsonToBean;

/**
 * @author huangbiaof
 * @data 创建时间：2019/9/19 10:33
 */

public class RedisMapServiceImpl extends BaseRedisService{


    /**
     * 获取值
     * @param prefix
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> List<T> get(KeyPrefix prefix, String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis =  getJedisPool().getResource();
            //生成真正的key
            String realKey  = prefix.getPrefix() + key;
            List<String> list = jedis.hmget(realKey,key);
            List<T> t =  JsonToBean(list, clazz);
            return t;
        }finally {
            returnToPool(jedis);
        }
    }


    public <T> boolean set(KeyPrefix prefix, String key, Map<String,String> map) {
        Jedis jedis = null;
        try {
            jedis =  getJedisPool().getResource();
            //生成真正的key
            String realKey  = prefix.getPrefix() + key;
            String  str = jedis.hmset(realKey,map);
            return true;
        }finally {
            returnToPool(jedis);
        }
    }


    /**
     * 直接放入map
     * @param prefix
     * @param key
     * @param map
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> boolean set(KeyPrefix prefix, String key, Map<String,T> map,Class<T> clazz) {

        Jedis jedis = null;
        Map<String, String> mapString = new HashMap<>();
        mapString = JsonTranslateUtil.mapToStringMap(map, clazz);
        try {
            jedis =  getJedisPool().getResource();
            //生成真正的key
            String realKey  = prefix.getPrefix() + key;
            String  str = jedis.hmset(realKey,mapString);
            return true;
        }finally {
            returnToPool(jedis);
        }
    }

    public <T> boolean exists(KeyPrefix prefix, String key) {
        return false;
    }


    public boolean delete(KeyPrefix prefix, String key) {
        return false;
    }

    public boolean delete(KeyPrefix prefix) {
        return false;
    }
}
