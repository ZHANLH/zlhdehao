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
