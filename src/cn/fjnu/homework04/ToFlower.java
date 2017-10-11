package cn.fjnu.homework04;

public class ToFlower {
	 public static void main(String[] args) {
	        int num = 0;   
	        for(int i = 100;i <= 999; i++){
	            int a = i/100;     
	            int b = (i-100*a)/10;      
	            int c = (i-b*10-a*100);     
	            
	            if(i==a*a*a+b*b*b+c*c*c){
	                num++;    
	                System.out.print(i+" ");  
	            }
	        }
	        System.out.println();    
	        System.out.println("水仙花数总共有"+num+"个");   
	    }
}
