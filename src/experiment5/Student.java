package experiment5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;  

public class Student implements Serializable, Comparable<Student>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1234L;
	private String studentID;
	private String name;
	private String sex;
	
	static public List<Student> s1 = new ArrayList<Student>();
	
	public void setStudentID(String studentID){
		this.studentID = studentID;
	}
	
	public String getID(){
		return studentID;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getSex(){
		return sex;
	}
	
	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", name=" + name + ", sex=" + sex + "]";
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		try {
        File fo = new File("H:/´óÈý/JAVA/list.txt");
        InputStreamReader so = new InputStreamReader(new FileInputStream(fo),"UTF-8");
        BufferedReader bf = new BufferedReader(so);
        Scanner scanner = new Scanner(bf);
        while (scanner.hasNext()) {
        	Student student = new Student();
        	student.studentID = scanner.next();
        	student.name = scanner.next();
        	student.sex = scanner.next();
        	s1.add(student);
        }
        Collections.sort(s1);
        scanner.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
        
		try {
			File fo2 = new File("student.bin");
			FileOutputStream bo = new FileOutputStream(fo2);
			ObjectOutputStream out = new ObjectOutputStream(bo);
        	for(int i=0; i < s1.size(); i++){
        		out.writeObject(s1.get(i));
        	}
        	out.flush();
        	FileInputStream co = new FileInputStream(fo2);
        	ObjectInputStream bc = new ObjectInputStream(co);
        	Student get = new Student();
        	while((get = (Student) bc.readObject()) != null){
        		System.out.println(get);
        	}
        	
        	out.close();
        	bc.close();
        	} catch (IOException ex) {
        	  // ex.printStackTrace();
        	}
   		}

	@Override
	public int compareTo(Student o) {
		return this.studentID.compareTo(o.studentID);
		// TODO Auto-generated method stub
	}
}





