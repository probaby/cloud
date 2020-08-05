package com.example.bean;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class CreateBeanTest {


    public void getBeanByBaseFactory() {
        Resource resource = new ClassPathResource("SpringXmlConfige.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        factory.getBean("userBean");
    }

    @Test
    public void getBean() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringXmlConfige.xml");
        System.out.println(applicationContext.getBean("userBean"));
    }

    @Test
    public void indendBean() {
        ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("SpringXmlIndepend.xml");
        System.out.println(classPath.getBean("testA"));
    }
}
