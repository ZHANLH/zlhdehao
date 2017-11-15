---
title: JAVAʵ��5

�Ӽ��̽����ֽ���
д�뵽��ǰĿ¼�µ�src.txt�ļ���
��src.txt�ļ����ݸ��Ƶ���ǰĿ¼��dest.txt�ļ���
��dest.txt�ļ�������ʾ����Ļ��

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


  
  
  
  ��ȡĳ��Ŀ¼�µ�Ŀ¼��Ϣ��Ŀ¼�ӿ���̨���롣
Ŀ¼��Ϣ������Ŀ¼�µ������ļ����ļ��е��б�����ÿ���ļ�����ʾ�����ƣ��޸����ڡ�����ÿ���ļ���ʾ�����ƣ��޸����ںʹ�С��
Ŀ¼����Ϣд�����ļ��С�ע�⣬�ļ���Ϣ���Ȱ����ͷ��࣬�ļ�����ǰ���ļ��ں󣬲������Ǹ��԰����ļ����ַ�����˳������
��չ�Լ���ѧ���֣�����JAVA��GUI��Swing�ȣ�����һ�����׵��ļ��������


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
			
		File src2 = new File("H:\\����\\JAVA\\ʵ��5\\2\\src2.txt");  
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
                 filetree("H:/����/JAVA");
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