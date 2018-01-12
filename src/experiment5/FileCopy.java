package experiment5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class FileCopy {
	public static void main(String[] args){
		try{
			File file = new File("H:/大三/JAVA/实验5/1.txt");
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
			BufferedReader br = new BufferedReader(isr);
			FileOutputStream fos = new FileOutputStream("H:/大三/JAVA/实验5/java_buff.txt");
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			PrintWriter pw=new PrintWriter(osw);
			
			String input;
			while ((input = br.readLine()) != null){
				System.out.println(input);
				bw.write(input + "\n");
			}
			
			bw.flush();
			br.close();
			isr.close();
			fis.close();
			pw.close();
			bw.close();
			osw.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
