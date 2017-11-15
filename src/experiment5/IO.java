package experiment5;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class IO {

	public static void main(String args[]) throws IOException {  
		
		File inFile1 = new File("src/src.txt");  
		inFile1.createNewFile();

        File inFile2 = new File("src/dest.txt"); 
        inFile2.createNewFile();

        FileOutputStream foutS = new FileOutputStream(inFile1);
        int b;
        while ((b = System.in.read()) != '!') {  
        	 foutS.write((char)b); 
        }
        foutS.close(); 
        FileInputStream finS = new FileInputStream(inFile1);
        FileOutputStream foutS2 = new FileOutputStream(inFile2);
        while ((b = finS.read()) != -1) {  
       	 foutS2.write(b); 
        }
        finS.close();
        foutS2.close();
        FileInputStream finS2 = new FileInputStream(inFile2);
        while((b = finS2.read()) != -1) {
			System.out.print((char)b);
		}
		finS2.close();
	}
}
