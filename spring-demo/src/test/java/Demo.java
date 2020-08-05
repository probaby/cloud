

public class Demo extends DemoB{
	public Demo(){
		System.out.println("Demo construct");
	}
	static{
		System.out.println("Demo static");
	}
	public static void  metho(){
		System.out.println("static method");
	}
	
	public  void  method(){
		System.out.println("static method");
	}
	
	public static void main(String[] args) {
		Demo demo = new  Demo();
		//DemoB.metho();
	}
//	volatile Integer v = 1;
//	DemoB  de = new DemoB();
//	public static void main(String[] args) {
//		Demo d = new Demo();
//		System.out.println("a");
//	}
}
class DemoB {
	public DemoB(){
		System.out.println("DemoB construct");
	}
	
	public  void  method(){
		System.out.println("methodB");
	} 
	static{
		System.out.println("DemoB static");
	}
	public static void  metho(){
		System.out.println("staticB method");
	}
}
