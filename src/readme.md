---
title: JAVAʵ�� 
tags:
grammar_cjkRuby: true
---

ͨ��������������JAVA�������ı�д��
ѧϰ�ϴ����뵽GitHub��վ��

�ж�����
��дJava��������ӹ�Ԫ1990�굽2007������
�������ţ�ÿ���������Ż�һ�С��ж������
��Ϊ����������ǣ�
��1��������ܱ�4�����������ܱ�100�������������ꣻ
��2��������ܱ�400����Ҳ�����ꡣ

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

�ٷ��Ƴɼ�ת��Ϊ�ȼ��ɼ�
ʵ�ַ���ToGradeScore�����ٷ��Ƴɼ�ת��Ϊ�ȼ��ɼ���Ҫ���һ�����ݣ�ʵ������ת����
�ȼ���ٷ��ƶ���
�ţ�[90,100]
����[89,80]
�У�[79,70]
����[69,60]
������[0,59]

    public class ToGradeScore {
	public static void main(String[] args){
		double score[]={96,97,83,50,60,70};
		for(int i = 0; i < 6; i++){
			if(score[i] >= 90 && score[i] <= 100){
				System.out.println("��");
			}
			if(score[i] >= 80 && score[i] <= 89){
				System.out.println("��");
			}
			if(score[i] >= 70 && score[i] <= 79){
				System.out.println("��");
			}
			if(score[i] >= 60 && score[i] <= 69){
				System.out.println("����");
			}
			if(score[i] >= 0 && score[i] <= 59){
				System.out.println("������");
			}
		}
	}
}

��ӡͼ��
����forѭ����дһ�����򣬽�����ͼ���ֱ��ӡ��
����
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

ˮ�ɻ���
��д�����ҳ����е�ˮ�ɻ�����ˮ�ɻ�������λ�������ĸ�λ���ֵ������͵��������λ������
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
	        System.out.println("ˮ�ɻ����ܹ���"+num+"��");   
	    }
}

JAVA����Ȩ�����η�������
��дһ������public��private��protected��default����Ȩ�޵����ݳ�Ա�ͳ�Ա������class��Ϊ������һ�����󲢽��йۣ����㳢��ȡ������class��Աʱ�������ʲô���͵ı�����Ϣ��

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
	//	System.out.print(A.b);   bΪ˽�У����ܱ�����
		System.out.print(A.c);
		System.out.print(A.d);
	}
    }
    public class class02 extends Testclass{
	public static void main(String[] args){
		Testclass A = new Testclass();
		System.out.print(A.a);
	//  System.out.print(A.b);   bΪ˽�У����ܱ�����
		System.out.print(A.c);
		System.out.print(A.d);
	}
	}
    public class class03 {
	public static void main(String[] args){
		Testclass A = new Testclass();
		System.out.print(A.a);
	//  System.out.print(A.b);   bΪ˽�У����ܱ�����
	//	System.out.print(A.c);   ��ͬ�İ�Ҳ���ܵ���
	//	System.out.print(A.d);   ��ͬ�İ�Ҳ���ܵ���
	}
    }
    public class class04 extends Testclass{
	public static void main(String[] args){
		Testclass A = new Testclass();
		System.out.print(A.a);
	//  System.out.print(A.b);   bΪ˽�У����ܱ�����
	//	System.out.print(A.c);   ��ʹ�̳�Testclass����ͬ�İ�Ҳ���ܵ���
	//	System.out.print(A.d);   ��ʹ�̳�Testclass����ͬ�İ�Ҳ���ܵ���
	}
    }

����ģʽ����ʹ�õ���ģʽ���������������
Choc-O-Holic��˾��һ���ɿ�����¯���������ɿ�����ţ���ں���һ�������ɿ���������������ɿ�����¯��ΪChocolateBoiler
ChocolateBoiler������˽�еĳ�Ա������empty��boiled�������жϹ�¯�Ƿ�Ϊ�գ��Լ���¯�ڻ�����Ƿ�����С�ע��������Ա����ǡ���ĳ�ʼֵ��
private boolean empty;
private boolean boiled;
ChocolateBoiler���������������ƹ�¯�����ɿ�������
public void fill() {��} ���¯�����ɿ�����ţ�̵Ļ�������Ҫ�жϹ�¯�Ƿ�Ϊ�գ�ֻ�пյĹ�¯��������ɿ�����ţ�̣������̴�ӡһ����伴�ɣ������֮��emptyΪfalse
public void boil() {��} ��¯����С������жϱ�־λ��ֻ�й�¯�����ģ�����û����������ܽ��иò�������в�����ӡһ����伴�ɣ�����к�boiled��־λ����Ϊtrue��
public void drain() {��} �ų���е��ɿ�����ţ�̡�����Ҫ���б�־λ�жϣ�ֻ�й�¯�����ģ����ҹ�¯�Ѿ����֮�󣬲����ų������ų������Ķ�����ӡһ����伴�ɣ����ų������֮������emptyΪtrue��
isEmpty��isBoiled��������ȡempty��boiled��־λ��ֵ

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
            System.out.println("������ɿ���");  
            uniqueInstance = new ChocolateBoiler();  
        }  
        System.out.println("�ɿ�����¯�ķ���");  
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