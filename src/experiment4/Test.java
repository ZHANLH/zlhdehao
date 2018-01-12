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
