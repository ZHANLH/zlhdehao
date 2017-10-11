package cn.fjnu.homework111;

import cn.fjnu.homework11.Testclass;

public class class04 extends Testclass{
	public static void main(String[] args){
		Testclass A = new Testclass();
		System.out.print(A.a);
	//  System.out.print(A.b);   b为私有，不能被调用
	//	System.out.print(A.c);   即使继承Testclass，不同的包也不能调用
	//	System.out.print(A.d);   即使继承Testclass，不同的包也不能调用
	}
}
