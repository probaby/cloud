package ncc.md.cache.redis.prefix;

import ncc.md.cache.redis.utils.IMDCacheConst;

/**
 * @author huangbiaof
 * @data 创建时间：2019/9/17 10:56
 */
public abstract class BasePrefix implements KeyPrefix{

	/**
	 * 过期时间
	 */
	private int expireSeconds;

	/**
	 * 前缀
	 */
	private String prefix;

	public BasePrefix(String prefix) {//0代表永不过期
		this(0, prefix);
	}

	public BasePrefix( int expireSeconds, String prefix) {
		this.expireSeconds = expireSeconds;
		this.prefix = prefix;
	}

	@Override
	public int expireSeconds() {//默认0代表永不过期
		return expireSeconds;
	}

	@Override
	public String getPrefix() {
		String prefix = this.prefix;
		return IMDCacheConst.MD+":"+this.prefix;
	}

	@Override
	public String buildKey(){
		return "";
	}

}
