package com.king.test;

public class InnerClassTest {
	public static void main(String[] args) {
		//test1
//        Outer.Inner oi = new Outer().new Inner();
//        oi.show();
        
        //test2
        Outer.method().show();
	}
}

//test1
//class Outer{
//  public int num = 10;
//  class Inner {//成员内部类
//      public int num = 20;
//      public void show() {
//          int num = 30;
//          System.out.println(num);    //填入合适的代码
//          System.out.println(this.num);
//          System.out.println(new Outer().num);
//      }
//  }
//}

//test2-1
//class Outer implements Inter{
//	@Override
//	public void show() {
//		// TODO Auto-generated method stub
//		System.out.print("hello world!");
//	}
//
//	public static Outer method() {
//		// TODO Auto-generated method stub
//		return new Outer();
//	}
//}

//test2-2
class Outer{
	public static Inter method() {
		return new Inter(){ //局部内部类、匿名内部类
			@Override
			public void show() {
				System.out.println("hello world!");
			}
		};
	}
}
 
interface Inter { 
    void show(); 
}
