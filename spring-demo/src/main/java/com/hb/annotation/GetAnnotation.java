package com.hb.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class GetAnnotation {
	public static void main(String[] args) throws ClassNotFoundException {
		getClazzAnnotation();
		getMethodAnnotation();
		getConstructorAnnotation();
	}
	public static void getClazzAnnotation() throws ClassNotFoundException{
		@SuppressWarnings("unchecked")
		Class<Test> clazz = (Class<Test>) Class.forName("com.hb.annotation.AnnotationDemo");
		Annotation an = clazz.isAnnotationPresent(Test.class)?clazz.getAnnotation(Test.class):null;
		Test te = (Test)an;
		System.out.println(te.id()+":"+Arrays.toString(te.name()));
	}
	public static void getMethodAnnotation() throws ClassNotFoundException{
		Method[] methods = Class.forName("com.hb.annotation.AnnotationDemo").getDeclaredMethods();
		for(Method method:methods){
			Annotation an = method.isAnnotationPresent(Test.class)?method.getAnnotation(Test.class):null;
			Test te = (Test)an;
			if(te==null)
				return ;
			System.out.println(te.id()+":"+Arrays.toString(te.name()));
		}
	}
	public static void getConstructorAnnotation() throws ClassNotFoundException{
		@SuppressWarnings({ "rawtypes" })
		Constructor[] constructors = Class.forName("com.hb.annotation.AnnotationDemo").getConstructors();
		for(Constructor<?> constructor:constructors){
			Annotation an = constructor.isAnnotationPresent(Test.class)?constructor.getAnnotation(Test.class):null;
			Test te = (Test)an;
			System.out.println(te.id()+":"+Arrays.toString(te.name()));
		}
	}
	
}
