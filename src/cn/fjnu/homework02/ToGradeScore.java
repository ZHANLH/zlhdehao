package cn.fjnu.homework02;

public class ToGradeScore {
	public static void main(String[] args){
		double score[]={96,97,83,50,60,70};
		for(int i = 0; i < 6; i++){
			if(score[i] >= 90 && score[i] <= 100){
				System.out.println("优");
			}
			if(score[i] >= 80 && score[i] <= 89){
				System.out.println("良");
			}
			if(score[i] >= 70 && score[i] <= 79){
				System.out.println("中");
			}
			if(score[i] >= 60 && score[i] <= 69){
				System.out.println("及格");
			}
			if(score[i] >= 0 && score[i] <= 59){
				System.out.println("不及格");
			}
		}
	}
}
