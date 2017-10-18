---
title: JAVA实验 
tags:
grammar_cjkRuby: true
---

通过几个程序掌握JAVA控制语句的编写。
学习上传代码到GitHub网站。

判断闰年
编写Java程序，输出从公元1990年到2007年所有
闰年的年号，每输出两个年号换一行。判断年号是
否为闰年的条件是：
（1）若年号能被4整除，而不能被100整除，则是闰年；
（2）若年号能被400整除也是闰年。

    public class year {
	public static void main(String[] args){
		int y = 1990;
		int num = 0;
		for (; y<2007; y++){
			if(((y % 4 == 0) && (y % 100 !=0)) || (y % 400 ==0)){
				num++;
				System.out.print(y);
				System.out.print(' ');
				if(num % 2 == 0){
					System.out.println();
				}
			}
		}
	}
}

百分制成绩转化为等级成绩
实现方法ToGradeScore，将百分制成绩转化为等级成绩。要求对一组数据，实现批量转化。
等级与百分制对照
优：[90,100]
良：[89,80]
中：[79,70]
及格：[69,60]
不及格：[0,59]

    public class ToGradeScore {
	public static void main(String[] args){
		double score[]={96,97,83,50,60,70};
		for(int i = 0; i < 6; i++){
			if(score[i] >= 90 && score[i] <= 100){
				System.out.println("优");
			}
			if(score[i] >= 80 && score[i] <= 89){
				System.out.println("良");
			}
			if(score[i] >= 70 && score[i] <= 79){
				System.out.println("中");
			}
			if(score[i] >= 60 && score[i] <= 69){
				System.out.println("及格");
			}
			if(score[i] >= 0 && score[i] <= 59){
				System.out.println("不及格");
			}
		}
	}
}

打印图案
利用for循环编写一个程序，将如下图案分别打印输
出。
      *
    ***
  *****
*******
  *****
    ***
      *

    public class ToFor {
	public static void main(String[] args){
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4-i; j++)
		      System.out.print(" ");
				System.out.print(" ");
				for(int k = 1; k <= 2*i-1; k++)
		    		System.out.print('*');
		    			System.out.println();
		}
	for(int i = 0; i < 4;i++){
			for(int j = 0; j <= i; j++)
				System.out.print(" ");
					for(int k = 5;k >= 2*i-1; k--)
						System.out.print('*');
							System.out.println();
		}
	}
}

水仙花数
编写程序找出所有的水仙花数；水仙花数是三位数，它的各位数字的立方和等于这个三位数本身。
package cn.fjnu.homework04;

    public class ToFlower {
	 public static void main(String[] args) {
	        int num = 0;   
	        for(int i = 100;i <= 999; i++){
	            int a = i/100;     
	            int b = (i-100*a)/10;      
	            int c = (i-b*10-a*100);     
	            	            
	            if(i==a*a*a+b*b*b+c*c*c){
	                num++;    
	                System.out.print(i+" ");  
	            }
	        }
	        System.out.println();    
	        System.out.println("水仙花数总共有"+num+"个");   
	    }
}

JAVA访问权限修饰符的掌握
编写一个具有public、private、protected、default访问权限的数据成员和成员函数的class。为它产生一个对象并进行观：当你尝试取用所有class成员时、会产生什么类型的编译消息。

    public class Testclass {
		public int a = 1;
		private int b = 2;
		protected int c = 3;
		int d = 4;
		public static void main(String[] args){
			Testclass A = new Testclass();
			System.out.print(A.a);
			System.out.print(A.b);
			System.out.print(A.c);
			System.out.print(A.d);
		}
    }
    public class class01 {
	public static void main(String[] args){
		Testclass A = new Testclass();
		System.out.print(A.a);
	//	System.out.print(A.b);   b为私有，不能被调用
		System.out.print(A.c);
		System.out.print(A.d);
	}
    }
    public class class02 extends Testclass{
	public static void main(String[] args){
		Testclass A = new Testclass();
		System.out.print(A.a);
	//  System.out.print(A.b);   b为私有，不能被调用
		System.out.print(A.c);
		System.out.print(A.d);
	}
	}
    public class class03 {
	public static void main(String[] args){
		Testclass A = new Testclass();
		System.out.print(A.a);
	//  System.out.print(A.b);   b为私有，不能被调用
	//	System.out.print(A.c);   不同的包也不能调用
	//	System.out.print(A.d);   不同的包也不能调用
	}
    }
    public class class04 extends Testclass{
	public static void main(String[] args){
		Testclass A = new Testclass();
		System.out.print(A.a);
	//  System.out.print(A.b);   b为私有，不能被调用
	//	System.out.print(A.c);   即使继承Testclass，不同的包也不能调用
	//	System.out.print(A.d);   即使继承Testclass，不同的包也不能调用
	}
    }

单例模式——使用单例模式完成下面描述的类
Choc-O-Holic公司有一个巧克力锅炉，用来把巧克力和牛奶融合在一起生产巧克力棒。定义这个巧克力锅炉类为ChocolateBoiler
ChocolateBoiler有两个私有的成员变量，empty和boiled，用来判断锅炉是否为空，以及锅炉内混合物是否已煮沸。注意两个成员变量恰当的初始值。
private boolean empty;
private boolean boiled;
ChocolateBoiler有三个方法来控制锅炉生产巧克力棒。
public void fill() {…} 向锅炉填满巧克力和牛奶的混合物。首先要判断锅炉是否为空，只有空的锅炉才能填充巧克力和牛奶（填充过程打印一条语句即可）。填充之后empty为false
public void boil() {…} 将炉内煮沸。首先判断标志位，只有锅炉是满的，并且没有煮过，才能进行该操作（煮沸操作打印一条语句即可）。煮沸后boiled标志位设置为true。
public void drain() {…} 排出煮沸的巧克力和牛奶。首先要进行标志位判断，只有锅炉是满的，并且锅炉已经煮沸之后，才能排出混合物（排出混合物的动作打印一条语句即可），排出混合物之后设置empty为true。
isEmpty和isBoiled方法来获取empty和boiled标志位的值

    public class ChocolateBoiler {  
    private boolean empty;  
    private boolean boiled;  
    private static ChocolateBoiler uniqueInstance;  
    
    private ChocolateBoiler() {  
        empty = true;  
        boiled = false;  
    }  
    
    public static ChocolateBoiler getInstance() {  
        if (uniqueInstance == null) {  
            System.out.println("制造出巧克力");  
            uniqueInstance = new ChocolateBoiler();  
        }  
        System.out.println("巧克力锅炉的返回");  
        return uniqueInstance;  
    }  
  
    public void fill() {  
        if (isEmpty()) {  
            empty = false;  
            boiled = false;  
        }  
    }  
   
    public void drain() {  
        if (!isEmpty() && isBoiled()) {  
            empty = true;  
        }  
    }  
   
    public void boil() {  
        if (!isEmpty() && !isBoiled()) {  
            boiled = true;  
        }  
    }  
    
    public boolean isEmpty() {  
        return empty;  
    }  
   
    public boolean isBoiled() {  
        return boiled;  
    }  
    }
	public class ChocolateController {
	   public static void main(String args[]) {  
	        ChocolateBoiler boiler = ChocolateBoiler.getInstance();  
	        boiler.fill();  
	        boiler.boil();  
	        boiler.drain();  
	    }  
    }