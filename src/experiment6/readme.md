---
title: ʵ��6

---
��ʵ�����еĵ���ģʽ���и��죬ʹ��֧�ֶ��̣߳��������̰߳�ȫ�ġ�

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
			System.out.println("����"+count+"���¯�����ɿ�����ţ�̵Ļ���� ��");
			empty=false;
		}
		else
			System.out.println("����"+count+"��¯�ѱ�������");
	}
	public void boil() {
		if(empty==false && boiled==false){
			System.out.println("����"+count+"��¯����С�");
			boiled=true;
		}
		else
			System.out.println("����"+count+"��¯�ѿջ��߹����Ѿ����ڡ�");
	}
	public void drain() {
		if(empty==false && boiled==true){
			System.out.println("����"+count+"�ų���е��ɿ�����ţ�̡�");
		}
		else
			System.out.println("����"+count+"��¯�ѿջ��߹���û�з��ڡ�");
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


  
  ����4���̷ֶ߳����1~100
�߳�1����1~25֮�ͣ��߳�2����26~50֮�ͣ��Դ�����
Ҫ���߳�1���֮��ִ���߳�2��֮��ִ���߳�3�����ִ���߳�4
��ӡÿ����ͽ�����Լ������ܽ�������ֱ��ӡ��һ����ͽ�����ڶ�����ͽ������������ͽ�������Ķ���ͽ�������յ���ͽ��

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