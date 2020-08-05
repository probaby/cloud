package com.hb.designPattern;



public class Singleton {
	public static void main(String[] args) {
		System.out.println(EnumSingleton.INSTANCE==EnumSingleton.INSTANCE);
	}
}
class Demo{
	 static int i = 0;
	 private Demo() throws Exception{
		 if(i!=0){
			 throw new Exception("创建过对象");
		 }
		 i++;
	 }
	 private Demo(String k) throws Exception{
		 System.out.println("demo String");
		 if(i!=0){
			throw new Exception("创建过对象");
		 }
		 i++;
	 }

}

//懒汉
class LazySingleton{
	 private static LazySingleton singLeton = new LazySingleton(); 
	 private LazySingleton(){
		 
	 }
	 public synchronized LazySingleton getLazySingleton(){
		 if(singLeton==null){
			 return new LazySingleton();
		 }
		 return singLeton;
	 }
}
//饿汉
class HunSingleton{
	 //安全，但类加载时就初始化
	 private static HunSingleton singleton = new HunSingleton();
	 private HunSingleton(){}
	 public static HunSingleton getHunSinglelton(){
		 return singleton;
	 }
}
//双重校验
class DoubleCheckSingleton{
	 private static DoubleCheckSingleton singleton;
	 private DoubleCheckSingleton(){}
	 public static DoubleCheckSingleton getHunSinglelton(){
		 if(singleton==null){
			 synchronized(DoubleCheckSingleton.class){
				 if(singleton==null){
					 return new DoubleCheckSingleton();
				 }
			 }
		 }
		 return singleton;
	 }
}
//静态内部类
class ClazzSingleton{
	 private ClazzSingleton(){};
	 public ClazzSingleton getSingleton(){
		 return InnerClazz.singleton;
	 }
	 static class InnerClazz{
		 private static ClazzSingleton singleton = new ClazzSingleton();
	 }
	 //解决序列化之后，重新读对象对象不一致的问题
	 private Object readResolve(){
		 return InnerClazz.singleton;
	 }
}
//单元素枚举
enum EnumSingleton{
	 INSTANCE;
	 public void show(){
		 System.out.println("Ea");
	 }
	 public Object readResolve(){
		 return INSTANCE;
	 }
}


//单例模式demo




