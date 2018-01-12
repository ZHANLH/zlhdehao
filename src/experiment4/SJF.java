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