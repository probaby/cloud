1. 使用配置文件

  * 引入jar包
```
<dependency>
    <groupId>com.github.pagehelper</groupId>
    <artifactId>pagehelper-spring-boot-starter</artifactId>
    <version>1.2.10</version>
</dependency>
<!--集成druid连接池-->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid-spring-boot-starter</artifactId>
    <version>1.1.10</version>
</dependency>
<!-- MyBatis 生成器 -->
<dependency>
    <groupId>org.mybatis.generator</groupId>
    <artifactId>mybatis-generator-core</artifactId>
    <version>1.3.3</version>
</dependency>
<!--Mysql数据库驱动-->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.15</version>
</dependency>
```
  * 配置文件
 
配置文件 UserMapper.xml
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.dao.mapper.UserMapper">

    <!-- 自定义返回结果集 -->
    <resultMap id="userMap" type="User">
        <id property="id" column="id" javaType="java.lang.Integer"></id>
        <result property="name" column="name" javaType="java.lang.String"></result>
        <result property="password" column="password" javaType="java.lang.String"></result>
        <result property="phone" column="account" javaType="java.lang.String"></result>
    </resultMap>


    <select id="GetUserByID" parameterType="int" resultMap="userMap">
        select * from `user` where id = #{id}
    </select>

    <select id="GetAllUser" resultMap="userMap">
        select * from `user`
    </select>
</mapper>
```
mybatis-config.xml
``` 
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <properties resource="mysql.properties"></properties>


    <typeAliases>
        <!-- 别名方式1，一个一个的配置 type中放置的是类的全路径，alias中放置的是类别名
        <typeAliase type="com.mybatis.demo.Entity.User" alias="UserBean"/> -->
        <!-- 别名方式2，自动扫描，将JAVA类的类名作为类的类别名 -->
        <!--<package name="com.mybatis.demo.Entity"/>-->
        <typeAlias alias="User" type="com.bean.User"/>
    </typeAliases>

    <!-- 配置mybatis运行环境 -->
    <environments default="development">
        <environment id="development">
            <!-- type="JDBC" 代表使用JDBC的提交和回滚来管理事务 -->
            <transactionManager type="JDBC"/>

            <!-- mybatis提供了3种数据源类型，分别是：POOLED,UNPOOLED,JNDI -->
            <!-- POOLED 表示支持JDBC数据源连接池 -->
            <!-- UNPOOLED 表示不支持数据源连接池 -->
            <!-- JNDI 表示支持外部数据源连接池 -->
            <dataSource type="POOLED">
                <property name="driver" value="${jdbc.driver}"/>
                <property name="url" value="${jdbc.databaseurl}"/>
                <property name="username" value="${jdbc.username}"/>
                <property name="password" value="${jdbc.password}"/>
            </dataSource>
        </environment>
    </environments>


    <mappers>
        <!-- 映射文件方式1，一个一个的配置-->
<!--        <mapper resource="mapper/UserMapper.xml"/>-->
        <!-- 映射文件方式2，自动扫描包内的Mapper接口与配置文件 -->
        <package name="com.dao.mapper"/>
    </mappers>

</configuration>
```
mysql.properties
```
jdbc.databaseurl=jdbc:mysql://192.168.5.101:3306/test?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.username=root
jdbc.password=root
jdbc.maxActive=100
jdbc.maxWait=5000
jdbc.filters=wall,stat
```
类：
```
package com.dao.mapper;

import com.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author huangbiaof
 * @data 创建时间：2019/7/23 13:06
 */

@Component
@Mapper
public interface UserMapper {

//    @Select("SELECT * FROM user WHERE PHONE = #{phone}")
//    public abstract User findUserByPhone(@Param("phone") String phone);
//
//    @Insert("INSERT INTO user(NAME, PASSWORD, PHONE) VALUES(#{name}, #{password}, #{phone})")
//    public abstract int insert(@Param("name") String name, @Param("password") String password, @Param("phone") String phone);
//
//    @Select("SELECT * FROM USER ")
//    public abstract User queryAllUser();

    @Select("SELECT * FROM user WHERE id = #{id}")
    public User GetUserByID(@Param("id") int id);

    @Select("SELECT * FROM user ")
    public List<User> GetAllUser();

}
```
测试类：
```
package com.example.mybatis;

import com.bean.User;
import com.dao.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {

        try {
            //使用MyBatis提供的Resources类加载mybatis的配置文件
            Reader reader = Resources.getResourceAsReader("mybatis/mybatis-config.xml");
            //构建sqlSession的工厂
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session= sessionFactory.openSession();
            UserMapper mapper=session.getMapper(UserMapper.class);
            List<User> user= mapper.GetAllUser();
            System.out.println(user.toString());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
```
2. 使用注解
上述已有注解部分
3. 使用Generator



4. 整合springboot