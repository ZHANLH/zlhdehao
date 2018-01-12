---
title: 实验4

---
FCFS算法按照任务到达的顺序进行服务，先来先服务
每个Task对象可以描述为至少包含下列属性：
taskID //任务ID
arrivalTime //到达时间
serviceTime //服务时间
startingTime //开始时间
finishingTime //完成时间=开始时间+服务时间
turnAroundTime //周转时间=完成时间-达到时间
weightTurnAround //带权周转时间=周转时间/服务时间
其他的属性根据程序需要设置

任务(Task)的ID、开始时间和服务时间由文件读入，形如右图所示。这个任务列表文件首先由程序生成，每秒一个任务达到，服务时间由{6,2,1,3,9}这个集合中的数据随机获取。文件列表要包含至少100个任务。
先要求实现如下要求的FCFS
当只有一个处理队列时的情况

SJF算法首先调度已到达的任务中，服务时间最短的任务，这里不要求实现任务的抢占。
按照FCFS算法的要求实现SJF算法，同样要求处理两种情况：
当有两个处理队列时的情况

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
	
	public int getSize(){//获取等待队列长度
		return waitQueue.size();
	}

	public FCFS(String name) {//构造器，读取文件内容并保存到任务队列中
		if (this.TaskQueue == null) {
			PutTaskQueue();
		}
		this.name 

     = name;
		isFree = true;
	}

	public static void FCFS_AddWaitQueue(){//从任务队列中加载任务到等待队列尾部
		if(TaskQueue.size()!=0){
			waitQueue.offer(TaskQueue.poll());
		}
		sumTime++;
	}
	public void start() {//开始处理入口
		if (isFree) {
			begin();
		} else {
			TaskWork();
		}
		
	}

	private void begin() {//当前等待队列根据服务时间进行排序，并且取任务开始工作
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

	private void TaskWork() {//任务工作，工作结束后跳出，开始下一项任务
		// TODO Auto-generated method stub
		
		if (sumTime == now.getFinishingTime()) {
			isFree = true;
			begin();
		}
	}

	private void PutTaskQueue() {//读取的文件内容赋值给任务队列
		this.TaskQueue = readFile();
	}

	private LinkedList<Task> readFile() {//读取文件内容并保存到任务队列
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


    public class SJF_SEIZE {//任务抢占类
	static LinkedList<Task> TaskQueue = null;
	private static LinkedList<Task> waitQueue = new LinkedList<Task>();
	private int sumTime;//开始服务时间
	private Task now;//当前任务对象
	private String name;//处理队列名
	
	public int getSize(){//获取等待队列长度
		return waitQueue.size();
	}
	
	public class TaskComparator implements Comparator<Task> {

		@Override
		public int compare(Task o1, Task o2) {
			// TODO Auto-generated method stub
			return (o1.getRemainingTine()-o2.getRemainingTine());
		}
		
	}

	public SJF_SEIZE(String name) {//构造器，读取文件内容并保存到任务队列中
		if (this.TaskQueue == null) {
			PutTaskQueue();
		}
		this.name 

     = name;
	}
	
	public static void SJF_AddWaitQueue(){//从任务队列中加载任务到等待队列尾部
		if(TaskQueue.size()!=0){
			waitQueue.offer(TaskQueue.poll());
		}
	}
	
	public void begin() {//当前等待队列根据服务时间进行排序，并且取任务开始工作
		Collections.sort(waitQueue, new TaskComparator());
		if(waitQueue.size()!=0){
			this.now = this.waitQueue.peek();
			if(now.getServiceTime()==now.getRemainingTine())
				now.setStartingTime(sumTime);
			TaskWork();
		}
	}

	private void TaskWork() {//任务工作
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

	private void PutTaskQueue() {//读取的文件内容赋值给任务队列
		this.TaskQueue = readFile();
	}

	private LinkedList<Task> readFile() {//读取文件内容并保存到任务队列
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
	
	public int getSize(){//获取等待队列长度
		return waitQueue.size();
	}
	
	public class TaskComparator implements Comparator<Task> {

		@Override
		public int compare(Task o1, Task o2) {
			// TODO Auto-generated method stub
			return (o1.getServiceTime()-o2.getServiceTime());
		}
		
	}

	public SJF(String name) {//构造器，读取文件内容并保存到任务队列中
		if (this.TaskQueue == null) {
			PutTaskQueue();
		}
		this.name 

     = name;
		isFree = true;
	}
	
	public static void SJF_AddWaitQueue(){//从任务队列中加载任务到等待队列尾部
		if(TaskQueue.size()!=0){
			waitQueue.offer(TaskQueue.poll());
		}
		sumTime++;
	}
	
	public void start() {//开始处理入口
		if (isFree) {
			begin();
		} else {
			TaskWork();
		}
	}
	
	

	private void begin() {//当前等待队列根据服务时间进行排序，并且取任务开始工作
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

	private void TaskWork() {//任务工作，工作结束后跳出，开始下一项任务
		// TODO Auto-generated method stub
		
		if (sumTime == now.getFinishingTime()) {
			isFree = true;
			begin();
		}

	}

	private void PutTaskQueue() {//读取的文件内容赋值给任务队列
		this.TaskQueue = readFile();
	}

	private LinkedList<Task> readFile() {//读取文件内容并保存到任务队列
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

    public class Task {//任务类
	private int taskID;
	private int arrivalTime; //到达时间
	private int serviceTime; //服务时间
	private int startingTime; //开始时间
	private int finishingTime; //完成时间=开始时间+服务时间
	private int turnAroundTime; //周转时间=完成时间-达到时间
	private double weightTurnAround; //带权周转时间=周转时间/服务时间
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
    //		System.out.println("先来先到服务：");
		System.out.println("taskID	arrivalTime	serviceTime	startingTime	finishingTime	turnAroundTime	weightTurnAround");
		do{
			FCFS.FCFS_AddWaitQueue();
			test1.start();
    //			test2.start();
		}while(test1.getSize()!=0 || FCFS.TaskQueue.size()!=0);
    //		while(test1.getSize()!=0 ||test2.getSize()!=0 || FCFS.TaskQueue.size()!=0);
    //		System.out.println("短作业优先服务：");
		System.out.println("taskID	arrivalTime	serviceTime	startingTime	finishingTime	turnAroundTime	weightTurnAround");
		do{
			SJF.SJF_AddWaitQueue();
			test3.start();
    //			test4.start();
		}while(test3.getSize()!=0 || SJF.TaskQueue.size()!=0);
    //		while(test3.getSize()!=0 ||test4.getSize()!=0 || SJF.TaskQueue.size()!=0);
    //		System.out.println("短作业优先抢占服务：");
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