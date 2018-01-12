---
title: ������readme

---

��PizzaStore�����̵�Ҫ������������������������
Public Pizza orderPizza(String type)������������type�������������������һ��Pizzaʵ��(ʵ����Ҫ����һ��������ʵ��)���������̰�����pizza.prepare(); pizza.bake(); pizza.cut(); pizza.box()��
Pizza�Ǹ������࣬������������ʵ�֣�CheesePizza,PepperoniPizza��ClamPizza��Pizza�еĳ��󷽷���
prepare();//׼������
bake();//�決����
cut();//�и�����
box();//����װ��
SimplePizzaFactory��һ�������������ɡ������������ݲ�ͬ��type���ɲ�ͬ��Pizzaʵ������ʵ�� CheesePizza,PepperoniPizza, ClamPizza �е�һ�֣�������public Pizza createPizza(String type)�������ɾ����Pizzaʵ�������type�ǡ�cheese������CheesePizza���ǡ�pepperoni������PepperoniPizza���ǡ�clam������ClamPizza��
PizzaStore�Ĺ��캯����Ҫ����SimplePizzaFactoryʵ����������orderPizza����������SimplePizzaFactoryʵ����������һ�������Pizza����ʵ����Ȼ�������������������pizza.prepare; pizza.bake(); pizza.cut(); pizza.box()����󷵻ظ�Pizza����ʵ����

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
		System.out.println("׼������");
	}
	public void bake(){
		System.out.println("��������");
	}
	public void cut(){
		System.out.println("�и�����");
	}
	public void box(){
		System.out.println("����װ��");
	}
    }
	
ClamPizza
	
	package cn.fjnu.homework13;

    public class ClamPizza extends Pizza{
	public void prepare(){
		System.out.println("׼������");
	}
	public void bake(){
		System.out.println("��������");
	}
	public void cut(){
		System.out.println("�и�����");
	}
	public void box(){
		System.out.println("����װ��");
	}
    }
	
CheesePizza
	
	package cn.fjnu.homework13;

    public class CheesePizza extends Pizza{
	public void prepare(){
		System.out.println("׼������");
	}
	public void bake(){
		System.out.println("��������");
	}
	public void cut(){
		System.out.println("�и�����");
	}
	public void box(){
		System.out.println("����װ��");
	}
    }
	
	
![enter description here][1]


  [1]: ./images/1515563529210.jpg