package com.example.redis;

import redis.clients.jedis.Jedis;

/**
 * @author huangbiaof
 * @data 创建时间：2019/7/9 20:12
 */



public class RedisDemo {
    /*
    maven
        <dependency>
            <groupId>redis.clients</groupId>
            <artifactId>jedis</artifactId>
            <version>2.9.0</version>
        </dependency>
     */
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");

    }

    public void getString(Jedis jedis) {
        jedis.set("okThing", "some");
        System.out.println(jedis.get("okThing"));
    }

    public void getList(Jedis jedis) {
        jedis.set("okThing", "some");
        System.out.println(jedis.get("okThing"));
    }

    public void getKeys(Jedis jedis) {
        jedis.set("okThing", "some");
        System.out.println(jedis.get("okThing"));
    }

}
