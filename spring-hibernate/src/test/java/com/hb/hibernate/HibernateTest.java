package com.hb.hibernate;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.hb.hibernate_out_spring.entity.Students;

public class HibernateTest {
	@Test
	public void test(){
		 //1. 创建一个SessionFactory 对象  
        SessionFactory sessionFactory = null;  
              
            //① 创建Configuration 对象：对应hibernate 的基本配置信息，和对象关系映射信息  
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");  
             /** 
              * 在hibernate 4.0 以前 创建session工厂 就是下面一条信息就可以了，4.0 版本以后的稍稍麻烦一点 
              * sessionFactory = configuration.buildSessionFactory(); 
              */  
            //② 创建一个ServiceRegistry 对象： 这个对象是hibernate4.0版本以后新添加的对象  
            // 其作用：hibernate 的任何配置和服务都要在该对象中注册后才能有效  
//            ServiceRegistry serviceRegistry =   
//                    new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())  
//                                                .getBootstrapServiceRegistry();      
            //③ 创建sessionFactory   
            sessionFactory = configuration.buildSessionFactory();
            //sessionFactory = configuration.buildSessionFactory(serviceRegistry);  
              
              
        //2. 创建一个Session 对象  
        Session session = sessionFactory.openSession();  
              
        //3. 开启事务  
        Transaction transaction = session.beginTransaction();  
          
        //4. 执行保存操作  
        Students students = new Students(3,"hb3",22,"ss3");  
        session.save(students);  
        Query query = session.createQuery("from Students as s where s.studentsId = :studentsId");
        query.setInteger("studentsId", 1);
        List result = query.list();
        System.out.println(result.get(0).toString());
        //query.setInteger("age", 1);
        
          
        //5. 提交事务  
        transaction.commit();  
          
        //6. 关闭Session  
        session.close();  
          
        //7. 关闭SessionFactory 对象  
        sessionFactory.close();  
          
    } 

}	
