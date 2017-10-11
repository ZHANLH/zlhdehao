package homework01;

public class year {
	public static void main(String[] args){
		int y = 1990;
		int num = 0;
		for (; y<2007; y++){
			if(((y % 4 == 0) && (y % 100 !=0)) || (y % 400 ==0)){
				num++;
				System.out.print(y);
				System.out.print(' ');
				if(num % 2 == 0){
					System.out.println();
				}
			}
		}
		
	}
	
}
