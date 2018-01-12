package me.ares.domain;

public class Process {
    private char processID;
    private int arrivalTime;   //到达时间
    private int serviceTime;   //服务时间
    private int startingTime; //开始时间
    private int finishingTime; //完成时间
    private int turnAroundTime; //周转时间
    private double averageTAT;  //带权周转时间
    private boolean visited = false; 
    
    public Process(char processID, int arrivalTime, int serviceTime) {
        super();
        this.processID = processID;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }
    
    public char getProcessID() {
        return processID;
    }

    public void setProcessID(char processID) {
        this.processID = processID;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public int getServiceTime() {
        return serviceTime;
    }
    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }
    public int getStartingTime() {
        return startingTime;
    }
    public void setStartingTime(int startingTime) {
        this.startingTime = startingTime;
    }
    public int getFinishingTime() {
        return finishingTime;
    }
    public void setFinishingTime(int finishingTime) {
        this.finishingTime = finishingTime;
    }
    public int getTurnAroundTime() {
        return turnAroundTime;
    }
    public void setTurnAroundTime(int turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }
    public double getAverageTAT() {
        return averageTAT;
    }
    public void setAverageTAT(double averageTAT) {
        this.averageTAT = averageTAT;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "Process [processID=" + processID + ", arrivalTime="
                + arrivalTime + ", serviceTime=" + serviceTime
                + ", startingTime=" + startingTime + ", finishingTime="
                + finishingTime + ", turnAroundTime=" + turnAroundTime
                + ", averageTAT=" + averageTAT 
                + "]";
    }

}