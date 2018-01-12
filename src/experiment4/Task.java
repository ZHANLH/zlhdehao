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
