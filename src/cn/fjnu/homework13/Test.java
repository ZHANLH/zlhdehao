package cn.fjnu.homework13;

public class Test {
	public static void main(String[] args){
		SimplePizzaFactory factory = new SimplePizzaFactory();
		PizzaStore pizza1 = new PizzaStore(factory);
		pizza1.orderPizza("cheese");
		System.out.println();
		pizza1.orderPizza("pepperoni");
		System.out.println();
		pizza1.orderPizza("clam");
		
	}
}
