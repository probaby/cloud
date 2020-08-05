package com.example.springcontrol.dispatch;


import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangbiaof
 * @data 创建时间：2019/8/7 13:24
 */

@RestController(value="hello")
public class DispatchControl {

    private DiscoveryClient discoveryClient;
//    private Registration client;

    @RequestMapping(value = "/hello")
    public String hello(){

        ServiceInstance service = discoveryClient.getLocalServiceInstance();
//        client.getHost();
        System.out.println(service.getHost()+"\nserviceId"+service.getServiceId());
        return "hello word";
    }

}
