package com.hb.json;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class FastjsonDemo {
	
	@Test
	public void test(){
		User user = new User(1,"1");
		Students student = new Students(2,"2",user);
		String s = JSON.toJSONString(student);
		System.out.println(s);

		Students student2 = JSON.parseObject(s,Students.class);
		System.out.println(student2.toString());
	}
}
class User {
	public int id;
	public String name;
	public User(){
		
	}

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + name;
	}
}
class Students {
	public int id;
	public String name;
	public User user;
	
	public Students(int id, String name, User user) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+name+user.toString();
	}
	
}
