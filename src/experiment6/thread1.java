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
