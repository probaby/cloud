package ncc.md.cache.redis;

import ncc.md.cache.redis.impl.RedisStringServiceImpl;
import ncc.md.cache.redis.utils.UserVO;

public class Demo {

	public static void main(String[] args) {
		UserVO user = new UserVO();
		user.setTime("a");
		user.setEmail("aa");
		user.setPassword("vvv");

		RedisStringServiceImpl redisService = new RedisStringServiceImpl();
		//key 为租户id + module id
		//redisService.set(MDPrefix.mdPrefix, "md", user);
redisService.getValueBylua();
		//System.out.println(redisService.get(MDPrefix.mdPrefix,"md",UserVO.class));
	}
}
