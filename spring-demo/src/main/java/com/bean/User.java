package com.bean;

/**
 * @author huangbiaof
 * @data 创建时间：2019/4/24 13:39
 */
public class User {


    private Integer id;
    private String name;
    private String password;
    private String phone;


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return id+name+password+phone;
    }
}
