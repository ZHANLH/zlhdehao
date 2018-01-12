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