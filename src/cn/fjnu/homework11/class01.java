package cn.fjnu.homework11;

public class class01 {
	public static void main(String[] args){
		Testclass A = new Testclass();
		System.out.print(A.a);
	//	System.out.print(A.b);   b为私有，不能被调用
		System.out.print(A.c);
		System.out.print(A.d);
	}
}
