package ncc.md.cache.redis.prefix;

/**
 * 生成key
 * @author huangbiaof
 *
 */
public interface KeyPrefix {

	public int expireSeconds();

	public String getPrefix();

	public String buildKey();

}
