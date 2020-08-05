package com.example.springcontrol.dispatch;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author huangbiaof
 * @data 创建时间：2019/8/7 13:24
 */

@RestController(value="hello")
public class DispatchControl {

//    private DiscoveryClient discoveryClient;
//    private Registration client;
    @Autowired
RestTemplate restTemplate;

    @RequestMapping(value = "/ribbon-consumer")
    public String hello(){

        return restTemplate.getForEntity("http://",String.class).getBody();
    }

}
