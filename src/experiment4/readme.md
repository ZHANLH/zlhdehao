---
title: ʵ��4

---
FCFS�㷨�������񵽴��˳����з��������ȷ���
ÿ��Task�����������Ϊ���ٰ����������ԣ�
taskID //����ID
arrivalTime //����ʱ��
serviceTime //����ʱ��
startingTime //��ʼʱ��
finishingTime //���ʱ��=��ʼʱ��+����ʱ��
turnAroundTime //��תʱ��=���ʱ��-�ﵽʱ��
weightTurnAround //��Ȩ��תʱ��=��תʱ��/����ʱ��
���������Ը��ݳ�����Ҫ����

����(Task)��ID����ʼʱ��ͷ���ʱ�����ļ����룬������ͼ��ʾ����������б��ļ������ɳ������ɣ�ÿ��һ������ﵽ������ʱ����{6,2,1,3,9}��������е����������ȡ���ļ��б�Ҫ��������100������
��Ҫ��ʵ������Ҫ���FCFS
��ֻ��һ���������ʱ�����

SJF�㷨���ȵ����ѵ���������У�����ʱ����̵��������ﲻҪ��ʵ���������ռ��
����FCFS�㷨��Ҫ��ʵ��SJF�㷨��ͬ��Ҫ�������������
���������������ʱ�����

CreateTxt

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
	
FCFS
	
	package experiment4;

    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.IOException;
    import java.util.LinkedList;


    public class FCFS {
	static LinkedList<Task> TaskQueue = null;
	static public LinkedList<Task> waitQueue = new LinkedList<Task>();
	static private int sumTime=-1;
	private boolean isFree;
	private Task now;
	private String name;
	
	public int getSize(){//��ȡ�ȴ����г���
		return waitQueue.size();
	}

	public FCFS(String name) {//����������ȡ�ļ����ݲ����浽���������
		if (this.TaskQueue == null) {
			PutTaskQueue();
		}
		this.name 

     = name;
		isFree = true;
	}

	public static void FCFS_AddWaitQueue(){//����������м������񵽵ȴ�����β��
		if(TaskQueue.size()!=0){
			waitQueue.offer(TaskQueue.poll());
		}
		sumTime++;
	}
	public void start() {//��ʼ�������
		if (isFree) {
			begin();
		} else {
			TaskWork();
		}
		
	}

	private void begin() {//��ǰ�ȴ����и��ݷ���ʱ��������򣬲���ȡ����ʼ����
		if(waitQueue.size()!=0){
			this.now = this.waitQueue.poll();
			isFree = false;
     //			System.out.println(sumTime);
			now.setStartingTime(sumTime);
			now.setFinishingTime(now.getStartingTime() + now.getServiceTime());
			now.setTurnAroundTime(now.getFinishingTime() - now.getArrivalTime());
			now.setWeightTurnAround(now.getTurnAroundTime() * 1.0
					/ now.getServiceTime());
    //			System.out.println(this.name 

     + ":" + now);
			System.out.println(now);
		}
	}

	private void TaskWork() {//��������������������������ʼ��һ������
		// TODO Auto-generated method stub
		
		if (sumTime == now.getFinishingTime()) {
			isFree = true;
			begin();
		}
	}

	private void PutTaskQueue() {//��ȡ���ļ����ݸ�ֵ���������
		this.TaskQueue = readFile();
	}

	private LinkedList<Task> readFile() {//��ȡ�ļ����ݲ����浽�������
    //		System.out.println("readFile");
		LinkedList<Task> queue = new LinkedList<Task>();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("src\\edu\\fjnu\\mse\\javatest4\\input.txt");
			br = new BufferedReader(fr);
			String line = "";
			String[] infos = null;
			while ((line = br.readLine()) != null) {
				Task temp = new Task();
				infos = line.split("	");
				temp.setTaskID(Integer.parseInt(infos[0]));
				temp.setArrivalTime(Integer.parseInt(infos[1]));
				temp.setServiceTime(Integer.parseInt(infos[2]));
    //				 System.out.println(temp);
				queue.offer(temp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return queue;

	}
    }


public class SJF_SEIZE {

    package experiment4;

    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.IOException;
    import java.util.Collections;
    import java.util.Comparator;
    import java.util.LinkedList;


    public class SJF_SEIZE {//������ռ��
	static LinkedList<Task> TaskQueue = null;
	private static LinkedList<Task> waitQueue = new LinkedList<Task>();
	private int sumTime;//��ʼ����ʱ��
	private Task now;//��ǰ�������
	private String name;//���������
	
	public int getSize(){//��ȡ�ȴ����г���
		return waitQueue.size();
	}
	
	public class TaskComparator implements Comparator<Task> {

		@Override
		public int compare(Task o1, Task o2) {
			// TODO Auto-generated method stub
			return (o1.getRemainingTine()-o2.getRemainingTine());
		}
		
	}

	public SJF_SEIZE(String name) {//����������ȡ�ļ����ݲ����浽���������
		if (this.TaskQueue == null) {
			PutTaskQueue();
		}
		this.name 

     = name;
	}
	
	public static void SJF_AddWaitQueue(){//����������м������񵽵ȴ�����β��
		if(TaskQueue.size()!=0){
			waitQueue.offer(TaskQueue.poll());
		}
	}
	
	public void begin() {//��ǰ�ȴ����и��ݷ���ʱ��������򣬲���ȡ����ʼ����
		Collections.sort(waitQueue, new TaskComparator());
		if(waitQueue.size()!=0){
			this.now = this.waitQueue.peek();
			if(now.getServiceTime()==now.getRemainingTine())
				now.setStartingTime(sumTime);
			TaskWork();
		}
	}

	private void TaskWork() {//������
		// TODO Auto-generated method stub
		now.setRemainingTine(now.getRemainingTine()-1);
		sumTime++;
		if(now.getRemainingTine()==0) {
			now.setFinishingTime(sumTime);
			now.setTurnAroundTime(now.getFinishingTime() - now.getArrivalTime());
			now.setWeightTurnAround(now.getTurnAroundTime() * 1.0
					/ now.getServiceTime());
    //			System.out.println(this.name 

     + ":" + now);
			System.out.println(now);
			waitQueue.remove();
		}

	}

	private void PutTaskQueue() {//��ȡ���ļ����ݸ�ֵ���������
		this.TaskQueue = readFile();
	}

	private LinkedList<Task> readFile() {//��ȡ�ļ����ݲ����浽�������
    //		System.out.println("readFile");
		LinkedList<Task> queue = new LinkedList<Task>();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("src\\edu\\fjnu\\mse\\javatest4\\input.txt");
			br = new BufferedReader(fr);
			String line = "";
			String[] infos = null;
			while ((line = br.readLine()) != null) {
				Task temp = new Task();
				infos = line.split("	");
				temp.setTaskID(Integer.parseInt(infos[0]));
				temp.setArrivalTime(Integer.parseInt(infos[1]));
				temp.setServiceTime(Integer.parseInt(infos[2]));
				temp.setRemainingTine(Integer.parseInt(infos[2]));
				// System.out.println(temp);
				queue.offer(temp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return queue;

	}
    }

SJF

        package experiment4;

    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.IOException;
    import java.util.Collections;
    import java.util.Comparator;
    import java.util.LinkedList;


    public class SJF {
	static LinkedList<Task> TaskQueue = null;
	private static LinkedList<Task> waitQueue = new LinkedList<Task>();
	static private int sumTime=-1;
	private boolean isFree;
	private Task now;
	private String name;
	
	public int getSize(){//��ȡ�ȴ����г���
		return waitQueue.size();
	}
	
	public class TaskComparator implements Comparator<Task> {

		@Override
		public int compare(Task o1, Task o2) {
			// TODO Auto-generated method stub
			return (o1.getServiceTime()-o2.getServiceTime());
		}
		
	}

	public SJF(String name) {//����������ȡ�ļ����ݲ����浽���������
		if (this.TaskQueue == null) {
			PutTaskQueue();
		}
		this.name 

     = name;
		isFree = true;
	}
	
	public static void SJF_AddWaitQueue(){//����������м������񵽵ȴ�����β��
		if(TaskQueue.size()!=0){
			waitQueue.offer(TaskQueue.poll());
		}
		sumTime++;
	}
	
	public void start() {//��ʼ�������
		if (isFree) {
			begin();
		} else {
			TaskWork();
		}
	}
	
	

	private void begin() {//��ǰ�ȴ����и��ݷ���ʱ��������򣬲���ȡ����ʼ����
		Collections.sort(waitQueue, new TaskComparator());
		if(waitQueue.size()!=0){
			this.now = this.waitQueue.poll();
			isFree = false;
			now.setStartingTime(sumTime);
			now.setFinishingTime(now.getStartingTime() + now.getServiceTime());
			now.setTurnAroundTime(now.getFinishingTime() - now.getArrivalTime());
			now.setWeightTurnAround(now.getTurnAroundTime() * 1.0
					/ now.getServiceTime());
    //			System.out.println(this.name 

     + ":" + now);
			System.out.println(now);
		}
	}

	private void TaskWork() {//��������������������������ʼ��һ������
		// TODO Auto-generated method stub
		
		if (sumTime == now.getFinishingTime()) {
			isFree = true;
			begin();
		}

	}

	private void PutTaskQueue() {//��ȡ���ļ����ݸ�ֵ���������
		this.TaskQueue = readFile();
	}

	private LinkedList<Task> readFile() {//��ȡ�ļ����ݲ����浽�������
		LinkedList<Task> queue = new LinkedList<Task>();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("src\\edu\\fjnu\\mse\\javatest4\\input.txt");
			br = new BufferedReader(fr);
			String line = "";
			String[] infos = null;
			while ((line = br.readLine()) != null) {
				Task temp = new Task();
				infos = line.split("	");
				temp.setTaskID(Integer.parseInt(infos[0]));
				temp.setArrivalTime(Integer.parseInt(infos[1]));
				temp.setServiceTime(Integer.parseInt(infos[2]));
				// System.out.println(temp);
				queue.offer(temp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return queue;

	}
    }

Task

    package experiment4;

    import java.text.DecimalFormat;

    public class Task {//������
	private int taskID;
	private int arrivalTime; //����ʱ��
	private int serviceTime; //����ʱ��
	private int startingTime; //��ʼʱ��
	private int finishingTime; //���ʱ��=��ʼʱ��+����ʱ��
	private int turnAroundTime; //��תʱ��=���ʱ��-�ﵽʱ��
	private double weightTurnAround; //��Ȩ��תʱ��=��תʱ��/����ʱ��
	private int RemainingTine;
	public int getTaskID() {
		return taskID;
	}
	public int getArrivalTime() {
		return arrivalTime;
	}
	public int getServiceTime() {
		return serviceTime;
	}
	public int getStartingTime() {
		return startingTime;
	}
	public int getFinishingTime() {
		return finishingTime;
	}
	public int getTurnAroundTime() {
		return turnAroundTime;
	}
	public double getWeightTurnAround() {
		return weightTurnAround;
	}
	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}
	public void setStartingTime(int startingTime) {
		this.startingTime = startingTime;
	}
	public void setFinishingTime(int finishingTime) {
		this.finishingTime = finishingTime;
	}
	public void setTurnAroundTime(int turnAroundTime) {
		this.turnAroundTime = turnAroundTime;
	}
	public void setWeightTurnAround(double weightTurnAround) {
		this.weightTurnAround = weightTurnAround;
	}
	public int getRemainingTine() {
		return RemainingTine;
	}
	public void setRemainingTine(int remainingTine) {
		RemainingTine = remainingTine;
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		return taskID +"		"+arrivalTime+"		"+serviceTime+"		"+startingTime +"		"+finishingTime
				+"		"+turnAroundTime +"		"+df.format(weightTurnAround);
	}
    }

Test

    package experiment4;

    public class Test {

	public static void main(String[] args) {
		//TODO Auto-generated method stub
		FCFS test1 = new FCFS("Test1");
		FCFS test2 = new FCFS("Test2");
		SJF test3 = new SJF("Test1");
		SJF test4 = new SJF("Test2");
		SJF_SEIZE test5 = new SJF_SEIZE("Test1");
		SJF_SEIZE test6 = new SJF_SEIZE("Test2");
    //		System.out.println("�����ȵ�����");
		System.out.println("taskID	arrivalTime	serviceTime	startingTime	finishingTime	turnAroundTime	weightTurnAround");
		do{
			FCFS.FCFS_AddWaitQueue();
			test1.start();
    //			test2.start();
		}while(test1.getSize()!=0 || FCFS.TaskQueue.size()!=0);
    //		while(test1.getSize()!=0 ||test2.getSize()!=0 || FCFS.TaskQueue.size()!=0);
    //		System.out.println("����ҵ���ȷ���");
		System.out.println("taskID	arrivalTime	serviceTime	startingTime	finishingTime	turnAroundTime	weightTurnAround");
		do{
			SJF.SJF_AddWaitQueue();
			test3.start();
    //			test4.start();
		}while(test3.getSize()!=0 || SJF.TaskQueue.size()!=0);
    //		while(test3.getSize()!=0 ||test4.getSize()!=0 || SJF.TaskQueue.size()!=0);
    //		System.out.println("����ҵ������ռ����");
		System.out.println("taskID	arrivalTime	serviceTime	startingTime	finishingTime	turnAroundTime	weightTurnAround");
		do{
			SJF_SEIZE.SJF_AddWaitQueue();
			test5.begin();
			test6.begin();
		}//while(test1.getWaitQueueSize()!=0 || SJF_SEIZE.TaskQueue.size()!=0);
		while(test5.getSize()!=0 ||test6.getSize()!=0 || SJF_SEIZE.TaskQueue.size()!=0);
	}
    }


![enter description here][1]


![enter description here][2]


![enter description here][3]


![enter description here][4]


![enter description here][5]


![enter description here][6]


  [1]: ./images/1515567483698.jpg
  [2]: ./images/1515567492010.jpg
  [3]: ./images/1515567500086.jpg
  [4]: ./images/1515567507218.jpg
  [5]: ./images/1515567520552.jpg
  [6]: ./images/1515567526404.jpg