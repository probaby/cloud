package com.example.json;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class FastJsonDemo {
    @Test
    public void testJson() {
        String s = "{\"code\":[\"aa\",\"aaaa\"]}";
        JSONObject json = JSONObject.parseObject(s);
        System.out.println(json.getJSONArray("code"));


    }
}
