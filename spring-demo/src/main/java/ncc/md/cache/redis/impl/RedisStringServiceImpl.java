package ncc.md.cache.redis.impl;

import ncc.md.cache.redis.prefix.KeyPrefix;
import ncc.md.cache.redis.utils.IMDCacheConst;
import ncc.md.cache.redis.utils.JsonTranslateUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static ncc.md.cache.redis.utils.JsonTranslateUtil.JsonToBean;
import static ncc.md.cache.redis.utils.JsonTranslateUtil.beanToJson;

/**
 * @author huangbiaof
 * @data 创建时间：2019/9/17 10:56
 */
public class RedisStringServiceImpl extends BaseRedisService {

	public RedisStringServiceImpl(){
		super();
	}

	/**
	 * 获取单个对象
	 * */

	public <T> T get(KeyPrefix prefix, String key , Class<T> clazz) {
		Jedis jedis = null;
		try {
			jedis =  getJedisPool().getResource();
			//生成真正的key
			String realKey  = prefix.getPrefix()+":" + key;
			//common
			String commonKey  = prefix.getPrefix()+":"+ IMDCacheConst.COMMON+":" + key;
			String result = jedis.get(commonKey);
			if(result==null){
				result = jedis.get(realKey);
			}

			T t =  JsonToBean(result, clazz);
			return t;
		}finally {
			returnToPool(jedis);
		}
	}

	/**
	 * 设置对象
	 * */

	public <T> boolean set(KeyPrefix prefix, String key,  T value) {
		Jedis jedis = null;
		try {
			jedis =  getJedisPool().getResource();
			String str = beanToJson(value);
			if(str == null || str.length() <= 0) {
				return false;
			}
			//生成真正的key
			String realKey  = prefix.getPrefix() + key;
			int seconds =  prefix.expireSeconds();
			if(seconds <= 0) {
				jedis.set(realKey, str);
			}else {
				jedis.setex(realKey, seconds, str);
			}
			return true;
		}finally {
			returnToPool(jedis);
		}
	}

	/**
	 * 判断key是否存在
	 * */

	public <T> boolean exists(KeyPrefix prefix, String key) {
		Jedis jedis = null;
		try {
			jedis =  getJedisPool().getResource();
			//生成真正的key
			String realKey  = prefix.getPrefix() + key;
			return  jedis.exists(realKey);
		}finally {
			returnToPool(jedis);
		}
	}

	/**
	 * 删除
	 * */

	public boolean delete(KeyPrefix prefix, String key) {
		Jedis jedis = null;
		try {
			jedis =  getJedisPool().getResource();
			//生成真正的key
			String realKey  = prefix.getPrefix() + key;
			long ret =  jedis.del(realKey);
			return ret > 0;
		}finally {
			returnToPool(jedis);
		}
	}

	/**
	 * 增加值
	 * */
	public <T> Long incr(KeyPrefix prefix, String key) {
		Jedis jedis = null;
		try {
			jedis =  getJedisPool().getResource();
			//生成真正的key
			String realKey  = prefix.getPrefix() + key;
			return  jedis.incr(realKey);
		}finally {
			returnToPool(jedis);
		}
	}

	/**
	 * 减少值
	 * */
	public <T> Long decr(KeyPrefix prefix, String key) {
		Jedis jedis = null;
		try {
			jedis =  getJedisPool().getResource();
			//生成真正的key
			String realKey  = prefix.getPrefix() + key;
			return  jedis.decr(realKey);
		}finally {
			returnToPool(jedis);
		}
	}
	public boolean delete(KeyPrefix prefix) {
		if(prefix == null) {
			return false;
		}
		List<String> keys = scanKeys(prefix.getPrefix());
		if(keys==null || keys.size() <= 0) {
			return true;
		}
		Jedis jedis = null;
		try {
			jedis = getJedisPool().getResource();
			jedis.del(keys.toArray(new String[0]));
			return true;
		} catch (final Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if(jedis != null) {
				jedis.close();
			}
		}
	}

	public List<String> scanKeys(String key) {
		Jedis jedis = null;
		try {
			jedis = getJedisPool().getResource();
			List<String> keys = new ArrayList<String>();
			String cursor = "0";
			ScanParams sp = new ScanParams();
			sp.match("*"+key+"*");
			sp.count(100);
			do{
				ScanResult<String> ret = jedis.scan(cursor, sp);
				List<String> result = ret.getResult();
				if(result!=null && result.size() > 0){
					keys.addAll(result);
				}
				//再处理cursor
				cursor = ret.getStringCursor();
			}while(!cursor.equals("0"));
			return keys;
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	public void getValueBylua(){
//		String script = "local key= KEYS[1]\n" +
//				"local names = redis.call('get', key)\n" +
//				"local infos = {}\n" +
//				"for word in string.gmatch(names, \"[%w-:]*\") do \n" +
//				"\tlocal value = redis.call(\"get\",word);\n" +
//				"\ttable.insert(infos,value); \n" +
//				"end\n" +
//				"return infos;";


//		String script = "local key= KEYS[1]\n" +
//				"local names = redis.call('get', key)\n" +
//				"local infos = {}\n" +
//				"if (names and string.find(names,','))  then\n" +
//				"\tfor word in string.gmatch(names, \"[%w-:]*\") do \n" +
//				"\t\tlocal value = redis.call(\"get\",word);\n" +
//				"\t\ttable.insert(infos,value); \n" +
//				"\tend\n" +
//				"else\n" +
//				"\ttable.insert(infos,names); \n" +
//				"end\n" +
//				"return infos;";
		String script = "local key= KEYS[1]\n" +
				"local names = redis.call('get', key)\n" +
				"local result = \"\";\n" +
				"if (names and string.find(names,','))  then\n" +
				"\tfor word in string.gmatch(names, \"[%w-:_]*\") do\n" +
				"\t\tlocal value = redis.call(\"get\",word);\n" +
				"\t\tif value then\n" +
				"\t\t\tresult = result..value;\n" +
				"\t\tend\n" +
				"\tend\n" +
				"else\n" +
				"\tif names then\n" +
				"\t\tresult = result..names;\n" +
				"\telse\n" +
				"\t\treturn names;\n" +
				"\tend\n" +
				"end\n" +
				"return result;";
		Jedis jedis = null;
		try {
			jedis =  getJedisPool().getResource();
			String s = jedis.eval(script,1,"md:mop:design:aea").toString();
			List<String> results = null;
			for (String result:results) {
				if(result!=null){
					byte[] by = new byte[0];
					try {
						by = new sun.misc.BASE64Decoder().decodeBuffer(result);
					} catch (IOException e) {
						e.printStackTrace();
					}
					by = JsonTranslateUtil.uncompress(by);
					Object object =  JsonTranslateUtil.deSerialize(by);
					System.out.println(object);
				}
			}
			System.out.println(results);
		}finally {
			returnToPool(jedis);
		}

	}


	public void spliteTest(){
		Jedis jedis = null;
		try {
			jedis = getJedisPool().getResource();

			byte[] str = jedis.get("md:mop:design:fi".getBytes());


			//this.spiltValue("md:mop:design:fi",str);


		} finally {
			returnToPool(jedis);
		}
	}

	//将序列化的value 做拆分
	public Map<String,String>  spiltValue(String key,String value) throws IOException {
		//超过5k 对value 进行拆分,每5k 为一个单元
		double valueLength = value.length();
		double num  = Math.floor(valueLength/IMDCacheConst.MAXLength);
		Map<String,String> map = null;
		if(num>1){
			for(int j = 1;j<=num;j++){
				int start = IMDCacheConst.MAXLength*(j-1);
				int end = IMDCacheConst.MAXLength*j;;
				String subString = value.substring(start, end);
				map.put(key+"_"+j,subString);
			}
		}
		return map;
	}

}
