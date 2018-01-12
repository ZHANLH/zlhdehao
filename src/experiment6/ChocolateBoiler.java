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