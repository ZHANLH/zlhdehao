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