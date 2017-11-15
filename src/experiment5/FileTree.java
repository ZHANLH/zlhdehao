package experiment5;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileTree {
	public FileTree(){
		
	}
	public static boolean filetree(String filepath) throws FileNotFoundException, IOException{
			
		File src2 = new File("H:\\大三\\JAVA\\实验5\\2\\src2.txt");  
		src2.createNewFile();
		Writer info = new FileWriter(src2);
	      try {
	    	  
              File file = new File(filepath);
              if (!file.isDirectory()) {
            	  info.write("name=" + file.getName());
            	  info.write("time=" + file.lastModified());
            	  info.write("size=" + file.length());

              } else if (file.isDirectory()) {
                      String[] filelist = file.list();
                      for (int i = 0; i < filelist.length; i++) {
                              File readfile = new File(filepath + "\\" + filelist[i]);
                              if (!readfile.isDirectory()) {
                                      info.write("name=" + readfile.getName());
                                      info.write("   ");
                                      info.write("time=" + readfile.lastModified());
                                      info.write("   ");
                                      info.write("size=" + readfile.length());
                                      info.write("\r\n");

                              } else if (readfile.isDirectory()) {
                            	  	filetree(filepath + "\\" + filelist[i]);
                              }
                      }

              }

      } catch (FileNotFoundException e) {
    	  info.write("readfile()   Exception:" + e.getMessage());
      }
	     info.close();
      return true;
	}
	 public static void main(String[] args) {
         try {
                 filetree("H:/大三/JAVA");
         } catch (FileNotFoundException ex) {
        	 
         } catch (IOException ex) {
        	 
         }
	 }
}
