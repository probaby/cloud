package com.redis;

import ncc.md.cache.redis.utils.IMDCacheConst;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huangbiaof
 * @data 创建时间：2019/8/27 16:52
 */

public class RedsiDemo {






//        private Jedis jedis;


//        public void setup() {
//            //连接redis服务器，192.168.0.100:6379
//            jedis = new Jedis("192.168.0.100", 6379);
//            //权限认证
//            jedis.auth("admin");
//        }
//
//        /**
//         * redis存储字符串
//         */
//
//        public void testString() {
//            //-----添加数据----------
//            jedis.set("name","xinxin");//向key-->name中放入了value-->xinxin
//            System.out.println(jedis.get("name"));//执行结果：xinxin
//
//            jedis.append("name", " is my lover"); //拼接
//            System.out.println(jedis.get("name"));
//
//            jedis.del("name");  //删除某个键
//            System.out.println(jedis.get("name"));
//            //设置多个键值对
//            jedis.mset("name","liuling","age","23","qq","476777XXX");
//            jedis.incr("age"); //进行加1操作
//            System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));
//
//        }
//
//        /**
//         * redis操作Map
//         */
//
//        public void testMap() {
//            //-----添加数据----------
//            Map<String, String> map = new HashMap<String, String>();
//            map.put("name", "xinxin");
//            map.put("age", "22");
//            map.put("qq", "123456");
//            jedis.hmset("user",map);
//            //取出user中的name，执行结果:[minxr]-->注意结果是一个泛型的List
//            //第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key可以跟多个，是可变参数
//            List<String> rsmap = jedis.hmget("user", "name", "age", "qq");
//            System.out.println(rsmap);
//
//            //删除map中的某个键值
//            jedis.hdel("user","age");
//            System.out.println(jedis.hmget("user", "age")); //因为删除了，所以返回的是null
//            System.out.println(jedis.hlen("user")); //返回key为user的键中存放的值的个数2
//            System.out.println(jedis.exists("user"));//是否存在key为user的记录 返回true
//            System.out.println(jedis.hkeys("user"));//返回map对象中的所有key
//            System.out.println(jedis.hvals("user"));//返回map对象中的所有value
//
//            Iterator<String> iter=jedis.hkeys("user").iterator();
//            while (iter.hasNext()){
//                String key = iter.next();
//                System.out.println(key+":"+jedis.hmget("user",key));
//            }
//        }
//
//        /**
//         * jedis操作List
//         */
//
//        public void testList(){
//            //开始前，先移除所有的内容
//            jedis.del("java framework");
//            System.out.println(jedis.lrange("java framework",0,-1));
//            //先向key java framework中存放三条数据
//            jedis.lpush("java framework","spring");
//            jedis.lpush("java framework","struts");
//            jedis.lpush("java framework","hibernate");
//            //再取出所有数据jedis.lrange是按范围取出，
//            // 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有
//            System.out.println(jedis.lrange("java framework",0,-1));
//
//            jedis.del("java framework");
//            jedis.rpush("java framework","spring");
//            jedis.rpush("java framework","struts");
//            jedis.rpush("java framework","hibernate");
//            System.out.println(jedis.lrange("java framework",0,-1));
//        }
//
//        /**
//         * jedis操作Set
//         */
//
//        public void testSet(){
//            //添加
//            jedis.sadd("user","liuling");
//            jedis.sadd("user","xinxin");
//            jedis.sadd("user","ling");
//            jedis.sadd("user","zhangxinxin");
//            jedis.sadd("user","who");
//            //移除noname
//            jedis.srem("user","who");
//            System.out.println(jedis.smembers("user"));//获取所有加入的value
//            System.out.println(jedis.sismember("user", "who"));//判断 who 是否是user集合的元素
//            System.out.println(jedis.srandmember("user"));
//            System.out.println(jedis.scard("user"));//返回集合的元素个数
//        }
//
//
//        public void test() throws InterruptedException {
//            //jedis 排序
//            //注意，此处的rpush和lpush是List的操作。是一个双向链表（但从表现来看的）
//            jedis.del("a");//先清除数据，再加入数据进行测试
//            jedis.rpush("a", "1");
//            jedis.lpush("a","6");
//            jedis.lpush("a","3");
//            jedis.lpush("a","9");
//            System.out.println(jedis.lrange("a",0,-1));// [9, 3, 6, 1]
//            System.out.println(jedis.sort("a")); //[1, 3, 6, 9]  //输入排序后结果
//            System.out.println(jedis.lrange("a",0,-1));
//        }


//        public void testRedisPool() {
//            RedisUtil.getJedis().set("newname", "中文测试");
//            System.out.println(RedisUtil.getJedis().get("newname"));
//        }

    public static void main(String[] args) {
        RedsiDemo redis = new RedsiDemo();

        String pathname  = "C:\\Users\\huangbiaof\\Desktop\\q.txt";
        StringBuffer sb = new StringBuffer();
        try{
            FileReader reader = new FileReader(pathname);
            BufferedReader br = new BufferedReader(reader);

            String line;
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                sb.append(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


//        redis.notSplit(sb.toString());
       redis.Split(sb.toString());

        Jedis jedis = RedisUtil.getJedis();
        long start = System.currentTimeMillis();
        jedis.get("keyAllsplit_5");
        long end = System.currentTimeMillis();
        System.out.println("keyAllsplit_5间隔"+(end-start));

    }


    public void notSplit(String content){
        long start = System.currentTimeMillis();
        System.out.println("notSplit 放入开始"+start);

        Jedis jedis = RedisUtil.getJedis();
        jedis.set("keyAll", content);
        RedisUtil.returnResource(jedis);

        long end = System.currentTimeMillis();
        System.out.println("notSplit放入结束"+end);
        System.out.println("notSplit放入间隔"+(end-start));


        for (int i =0;i<50;i++){
            Thread run = new NotSplitRunable();
            run.start();
        }



//        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
//                .setNameFormat("demo-pool-%d").build();
//
//        ExecutorService pool = new ThreadPoolExecutor(5, 200,
//                0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
//
//        pool.execute(()-> new NotSplitRunable());
//        pool.shutdown();//gracefully shutdown


    }

    public void Split(String content){
        long start = System.currentTimeMillis();
        System.out.println("Split 放入开始"+start);

        Jedis jedis = RedisUtil.getJedis();
        try {
            this.set(spiltValue("keyAllsplit", content));
        } catch (IOException e) {
            e.printStackTrace();
        }

        RedisUtil.returnResource(jedis);

        long end = System.currentTimeMillis();
        System.out.println("Split放入结束"+end);
        System.out.println("Split放入间隔"+(end-start));


        for (int i =0;i<50;i++){
            Thread run = new SplitRunable();
            run.start();
        }
    }


    class NotSplitRunable extends Thread{

        @Override
        public void run() {
            long id = Thread.currentThread().getId();


            Jedis jedis = RedisUtil.getJedis();

            long start = System.currentTimeMillis();
            //System.out.println(id + "    notSplit开始"+start);
            String s = jedis.get("keyAll");
//            System.out.println(s);
            long end = System.currentTimeMillis();
           // System.out.println(id + "    notSplit结束"+end);
            //id + "    notSplit间隔"+
            System.out.println((end-start));

            RedisUtil.returnResource(jedis);


        }
    }

    class SplitRunable extends Thread{

        @Override
        public void run() {
            long id = Thread.currentThread().getId();


            Jedis jedis = RedisUtil.getJedis();

            long start = System.currentTimeMillis();
            //System.out.println(id + "    Split开始"+start);
            String s = getValueBylua("keyAllsplit",jedis);

            long end = System.currentTimeMillis();
            //System.out.println(id + "    Split结束"+end);
            //id + "    Split间隔"+
            System.out.println((end-start));

//            System.out.println(s);
            RedisUtil.returnResource(jedis);


        }
    }

    // 将序列化的value 做拆分
    public Map<String, String> spiltValue(String key, String value) throws IOException {
        // 超过5k 对value 进行拆分,每5k 为一个单元
        double valueLength = value.length();
        double num = Math.ceil(valueLength / IMDCacheConst.MAXLength);
        Map<String, String> map = null;
        StringBuffer keyCon = new StringBuffer();
        if (num > 1) {
            map = new HashMap<String, String>();
            for (int j = 1; j <= num; j++) {
                int start = IMDCacheConst.MAXLength * (j - 1);
                int end = (int) (j==num?valueLength:(IMDCacheConst.MAXLength * j));
                ;
                String subString = value.substring(start, end);
                String keySub = key + "_" + j;
                keyCon.append((j == 1 ? "" : ",") + keySub);
                map.put(keySub, subString);
            }
            map.put(key, keyCon.toString());
        }
        return map;
    }

    public String getValueBylua(String key,Jedis jedis) {
//		String script = "local key= KEYS[1]\n" + "local "
//				+ "names = redis.call('get', key)\n" + "local infos = {}\n"
//				+ "if (names and string.find(names,','))  then\n" + "\tfor word in string.gmatch(names, \"[%w-:]*\") do \n"
//				+ "\t\tlocal value = redis.call(\"get\",word);\n" + "\t\ttable.insert(infos,value); \n" + "\tend\n"
//				+ "else\n" + "\ttable.insert(infos,names); \n" + "end\n" + "return infos;";

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
        Object result = luaScript(script,jedis, key);
        String resultStr = null;
        if(result!=null) {
            resultStr = result.toString();
        }
        StringBuffer build = new StringBuffer();

        return resultStr;

    }
    public Object luaScript(String script, Jedis jedis,String... key) {

//        String sha1 = jedis.scriptLoad(script);
//        Object results = jedis.evalsha(sha1, key.length, key);
        Object results = jedis.eval(script, key.length, key);
        return results;

    }

    public boolean set(Map<String, String> map) throws IOException {
        Jedis jedis = null;
        try {
            jedis = RedisUtil.getJedis();
            Pipeline pipelined = jedis.pipelined();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                pipelined.set(entry.getKey(), entry.getValue());
            }
            pipelined.sync();
            pipelined.close();
            return true;
        } finally {
            RedisUtil.returnResource(jedis);
        }
    }

}
