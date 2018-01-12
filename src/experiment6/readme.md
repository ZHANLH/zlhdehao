---
title: 实验6

---
对实验三中的单例模式进行改造，使其支持多线程，并且是线程安全的。

ChocolateBoiler

    package experiment6;

    public class ChocolateBoiler extends Thread {
	private boolean empty;
	private boolean boiled;
	public  int count;
	static Object key = "this is a key";
	ChocolateBoiler(int count) {
		empty=true;
		boiled=false;
		this.count=count;
	}
	public void fill() {
		if(empty==true) {
			System.out.println("工厂"+count+"向锅炉填满巧克力和牛奶的混合物 。");
			empty=false;
		}
		else
			System.out.println("工厂"+count+"锅炉已被填满。");
	}
	public void boil() {
		if(empty==false && boiled==false){
			System.out.println("工厂"+count+"将炉内煮沸。");
			boiled=true;
		}
		else
			System.out.println("工厂"+count+"锅炉已空或者锅内已经沸腾。");
	}
	public void drain() {
		if(empty==false && boiled==true){
			System.out.println("工厂"+count+"排出煮沸的巧克力和牛奶。");
		}
		else
			System.out.println("工厂"+count+"锅炉已空或者锅内没有沸腾。");
	} 
	public boolean isEmpty() {
		return empty;
	}
	public boolean isBoiled() {
		return boiled;
	}
	
	
	public void run() {
		 synchronized (key) {
			this.fill();
			this.boil();
			this.drain();
         }  
         try {  
              sleep(1000);
         } catch (InterruptedException e) {  
             e.printStackTrace();  
         }  
        
	}
	
    }
	
TestChocolateBoiler
	
	package experiment6;

    public class TestChocolateBoiler {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChocolateBoiler thr1 = new ChocolateBoiler(1);
		ChocolateBoiler thr2 = new ChocolateBoiler(2);
		ChocolateBoiler thr3 = new ChocolateBoiler(3);
		ChocolateBoiler thr4 = new ChocolateBoiler(4);
		thr1.start();
		thr2.start();
		thr3.start();
		thr4.start();
	}

    }
	
![enter description here][1]


  
  利用4个线程分段求和1~100
线程1计算1~25之和；线程2计算26~50之和；以此类推
要求线程1完成之后执行线程2，之后执行线程3，最后执行线程4
打印每段求和结果，以及最后的总结果。即分别打印第一段求和结果，第二段求和结果，第三段求和结果，第四段求和结果，最终的求和结果

    package experiment6;

    public class thread1 implements Runnable{
	
	private static Thread [] jobs = new Thread[4];
    int count;
    static int total;
	int t = 0;
	public thread1(int a){
		count = a;
	}
	public void run(){
		for(int i = 0; i < 25; i++){
			t = t + count;
			count++;
		}
			try {
				Thread.sleep(100);
				} catch (Exception e) {
				e.printStackTrace();
				}
		System.out.println(t);
		total = total +t;
	}
	
	public static void main(String[] args){
		int j = 0;
		try {
				for(int i=0; i<jobs.length; i++) {
					j = 1+25*i;
					jobs[i] = new Thread(new thread1(j));
					jobs[i].start();
					jobs[i].join();
				}
			} catch(InterruptedException e) { System.out.println(e); }
		System.out.println(total);
	}
    }


![enter description here][2]


  [1]: ./images/1515564375458.jpg
  [2]: ./images/1515564451789.jpg