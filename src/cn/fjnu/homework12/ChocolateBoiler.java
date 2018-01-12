package cn.fjnu.homework12;

public class ChocolateBoiler implements Runnable{  
    private boolean empty;  
    private boolean boiled;  
    private static ChocolateBoiler uniqueInstance;  
    
    private ChocolateBoiler() {  
        empty = true;  
        boiled = false;  
    }  
    
    public static ChocolateBoiler getInstance() {  
        if (uniqueInstance == null) {  
            System.out.println("制造出巧克力");  
            uniqueInstance = new ChocolateBoiler();  
        }  
        System.out.println("巧克力锅炉的返回");  
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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}  
}  