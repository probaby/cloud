package ncc.md.cache.redis;

import ncc.md.cache.redis.vo.RedisConfig;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author huangbiaof
 * @data 创建时间：2019/9/17 10:56
 */
public class RedisPoolFactory {

	JedisPool jedisPool;

	private RedisPoolFactory() {
		init();
	}
	
	private static class NestClass {
		private static RedisPoolFactory instance;
		static{
			instance = new RedisPoolFactory();
		}
	}
	
	public static RedisPoolFactory getIntance() {
		return NestClass.instance;
	}

	public JedisPool getJedisPool() {
		return jedisPool;
	}
	
	public void init() {
		RedisConfig redisConfig = new RedisConfig();
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxIdle(redisConfig.getPoolMaxIdle());
		poolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
		poolConfig.setMaxWaitMillis(redisConfig.getPoolMaxWait() * 1000);
		JedisPool jp = new JedisPool(poolConfig, redisConfig.getHost(), redisConfig.getPort(),
				redisConfig.getTimeout()*1000, redisConfig.getPassword(), 0);
		this.jedisPool = jp;
	}
	
}
