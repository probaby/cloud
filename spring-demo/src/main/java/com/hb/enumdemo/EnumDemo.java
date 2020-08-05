package com.hb.enumdemo;

import java.util.EnumSet;

public class EnumDemo {
	enum Demo{
		UNDERSTATE{
			void show(){
				System.out.println("UNDERSTATE show");
			}
		},
		ONSTATE{
			void show(){
				System.out.println("ONSTATE show");
			}
		},
		OUTSTATE{
			void show(){
				System.out.println("OUTSTATE show");
			}
		},
		INSTATE{
			void show(){
				System.out.println("INSTATE show");
			}
			void test(){
				System.out.println("INSTATE test");
			}
		};
		abstract void show();
		void test(){
			System.out.println("default test");
		}
	}
	EnumSet<Demo> demos = EnumSet.of(Demo.INSTATE);
	public void addEnum(Demo demo){
		demos.add(demo);
	}
	public void showEnum(){
		for (Demo demo : demos) {
			demo.test();
			demo.show();
		}
	}
	public static void main(String[] args) {
		EnumDemo en = new EnumDemo();
		en.addEnum(Demo.OUTSTATE);
		en.addEnum(Demo.ONSTATE);
		en.addEnum(Demo.UNDERSTATE);
		en.showEnum();
	}
}
