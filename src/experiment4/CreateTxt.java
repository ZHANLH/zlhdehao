package experiment4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;  
import java.io.FileOutputStream;  
import java.io.FileReader;
import java.io.FileWriter;
import java.io.RandomAccessFile; 

public class CreateTxt {
	
	public static File fileName;
	
	CreateTxt(File fileName){//������
		this.fileName=fileName;
	}
	 
	 public static boolean writeTxtFile(String content)throws Exception{  //д���������ǻḲ��ԭ��������
		 RandomAccessFile mm=null;  
		 boolean flag=false;  
		 FileOutputStream o=null;  
		 try {  
			 o = new FileOutputStream(fileName);//�����ļ�  
			 o.write(content.getBytes("GBK"));  
			 o.close();  
			 flag=true;  
		 } 
		 catch (Exception e) {  
			 e.printStackTrace();  
		 }
		 finally{  
			 if(mm!=null){  
				 mm.close();  
			 }  
		 }  
		 return flag;  
	 }  
	 public static void contentToTxt(String content) { //д��������ԭ�����ݵĻ��������
		 String str = new String(); //ԭ��txt����  
	     String s1 = new String();//���ݸ���  
	     try {  
	         BufferedReader input = new BufferedReader(new FileReader(fileName));  
	         while ((str = input.readLine()) != null) {  
	             s1 += str + "\r\n";  
	         }  
	         input.close();  
	         s1 += content;  
	         BufferedWriter output = new BufferedWriter(new FileWriter(fileName));  
	         output.write(s1);  
	         output.close();  
	      } 
	      catch (Exception e) {  
	         e.printStackTrace();  
	  
	      }  
	 }  
	 public void writecontent() throws Exception{//Ӧ�õ�д������Ϊȷ��������ӣ��ȶ��ļ�������գ���д��
		//��д��֮ǰ�ÿ�TXT�ļ�����ֹ��������
		try {
			writeTxtFile("");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			 
		//��ʼTXT�ļ�����д��
		String temp =null;//�ļ����ݱ������
		int []ServiceTime = {6,2,1,3,9};
		for(int i=0;i<100;i++) {
			int x=(int)(Math.random()*5);
			temp=(i+1)+"	"+i+"	"+ServiceTime[x];
			//writeTxtFile(temp,fileName);
			contentToTxt(temp);
		}
	 }
	 public static void main(String []args) throws Exception {
		String filePath="C:\\Users\\slayer\\Desktop\\Test.txt";//�ļ���ַ
		File file = new File(filePath);
		CreateTxt test= new CreateTxt(file);
		test.writecontent();
	 }
}

