---
title: 披萨店readme

---

类PizzaStore披萨商店要接收披萨订单生产披萨，其
Public Pizza orderPizza(String type)根据披萨类型type完成披萨制作，并返回一个Pizza实例(实际上要返回一个其子类实例)。制作过程包括（pizza.prepare(); pizza.bake(); pizza.cut(); pizza.box()）
Pizza是个抽象类，其有三个子类实现：CheesePizza,PepperoniPizza和ClamPizza。Pizza中的抽象方法有
prepare();//准备材料
bake();//烘焙披萨
cut();//切割披萨
box();//披萨装包
SimplePizzaFactory是一个披萨对象生成“工厂”，根据不同的type生成不同的Pizza实例（其实是 CheesePizza,PepperoniPizza, ClamPizza 中的一种）。利用public Pizza createPizza(String type)方法生成具体的Pizza实例，如果type是”cheese”生成CheesePizza，是”pepperoni”生成PepperoniPizza，是”clam”生成ClamPizza。
PizzaStore的构造函数需要传入SimplePizzaFactory实例，并且在orderPizza方法中利用SimplePizzaFactory实例首先生成一个具体的Pizza子类实例，然后进行披萨生产，包括pizza.prepare; pizza.bake(); pizza.cut(); pizza.box()，最后返回该Pizza子类实例。

SimplePizzaFactory

    package cn.fjnu.homework13;

    public class SimplePizzaFactory {

	public Pizza createPizza(String type){
		Pizza pizza = null;
		
		if (type.equals("cheese")){
			pizza = new CheesePizza();
		} 
		else if (type.equals("pepperoni")){
			pizza = new PepperoniPizza();
		}
		else if (type.equals("clam")){
			pizza = new ClamPizza();
		}
			
		return pizza;
	}
    }
	
PizzaStore
	
	    package cn.fjnu.homework13;

    public class PizzaStore {
	SimplePizzaFactory factory;
	public PizzaStore(SimplePizzaFactory factory){
		this.factory = factory;
	}
	public Pizza orderPizza(String type){
		Pizza pizza;
		pizza = factory.createPizza(type);
		pizza.prepare(); 
		pizza.bake(); 
		pizza.cut(); 
		pizza.box();
		return pizza;
	}
    }

Pizza

    package cn.fjnu.homework13;

    public abstract class Pizza {

	public abstract void prepare();
	public abstract void bake();
	public abstract void cut();
	public abstract void box();
	
    }

Test

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
	
PepperoniPizza
	
	package cn.fjnu.homework13;

    public class PepperoniPizza extends Pizza{
	public void prepare(){
		System.out.println("准备材料");
	}
	public void bake(){
		System.out.println("烘培披萨");
	}
	public void cut(){
		System.out.println("切割披萨");
	}
	public void box(){
		System.out.println("披萨装包");
	}
    }
	
ClamPizza
	
	package cn.fjnu.homework13;

    public class ClamPizza extends Pizza{
	public void prepare(){
		System.out.println("准备材料");
	}
	public void bake(){
		System.out.println("烘培披萨");
	}
	public void cut(){
		System.out.println("切割披萨");
	}
	public void box(){
		System.out.println("披萨装包");
	}
    }
	
CheesePizza
	
	package cn.fjnu.homework13;

    public class CheesePizza extends Pizza{
	public void prepare(){
		System.out.println("准备材料");
	}
	public void bake(){
		System.out.println("烘培披萨");
	}
	public void cut(){
		System.out.println("切割披萨");
	}
	public void box(){
		System.out.println("披萨装包");
	}
    }
	
	
![enter description here][1]


  [1]: ./images/1515563529210.jpg