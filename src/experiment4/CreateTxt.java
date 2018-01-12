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
	
	CreateTxt(File fileName){//构造器
		this.fileName=fileName;
	}
	 
	 public static boolean writeTxtFile(String content)throws Exception{  //写操作，但是会覆盖原来的内容
		 RandomAccessFile mm=null;  
		 boolean flag=false;  
		 FileOutputStream o=null;  
		 try {  
			 o = new FileOutputStream(fileName);//创建文件  
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
	 public static void contentToTxt(String content) { //写操作，在原来内容的基础上添加
		 String str = new String(); //原有txt内容  
	     String s1 = new String();//内容更新  
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
	 public void writecontent() throws Exception{//应用的写函数，为确保不会叠加，先对文件进行清空，在写入
		//在写入之前置空TXT文件，防止叠加冗余
		try {
			writeTxtFile("");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			 
		//开始TXT文件内容写入
		String temp =null;//文件内容保存变量
		int []ServiceTime = {6,2,1,3,9};
		for(int i=0;i<100;i++) {
			int x=(int)(Math.random()*5);
			temp=(i+1)+"	"+i+"	"+ServiceTime[x];
			//writeTxtFile(temp,fileName);
			contentToTxt(temp);
		}
	 }
	 public static void main(String []args) throws Exception {
		String filePath="C:\\Users\\slayer\\Desktop\\Test.txt";//文件地址
		File file = new File(filePath);
		CreateTxt test= new CreateTxt(file);
		test.writecontent();
	 }
}

