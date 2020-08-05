package com.dao.mapper;

import com.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author huangbiaof
 * @data 创建时间：2019/7/23 13:06
 */

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

//    @Select("SELECT * FROM user WHERE id = #{id}")
//    public User GetUserByID(@Param("id") int id);
//
//    @Select("SELECT * FROM user ")
//    public List<User> GetAllUser();

    public User GetUserByID(@Param("id") int id);

    public List<User> GetAllUser();

}

