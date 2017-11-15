---
title: JAVA实验5

从键盘接收字节流
写入到当前目录下的src.txt文件中
将src.txt文件内容复制到当前目录下dest.txt文件中
将dest.txt文件内容显示到屏幕上

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

![enter description here][1]


![enter description here][2]


![enter description here][3]


  
  
  
  获取某个目录下的目录信息，目录从控制台输入。
目录信息包括该目录下的所有文件和文件夹的列表。对于每个文件夹显示其名称，修改日期。对于每个文件显示其名称，修改日期和大小。
目录的信息写出到文件中。注意，文件信息首先按类型分类，文件夹在前，文件在后，并且他们各自按照文件名字符串的顺序排序。
扩展以及自学部分：利用JAVA的GUI（Swing等）创建一个简易的文件浏览器。


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
![enter description here][4]


  [1]: ./images/1510752317424.jpg
  [2]: ./images/1510752329752.jpg
  [3]: ./images/1510752338004.jpg
  [4]: ./images/1510752513863.jpg