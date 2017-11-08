---
title: JAVA实验4 

模拟实现FCFS（先来先服务）算法-1

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

模拟实现FCFS（先来先服务）算法-2

任务(Task)的ID、开始时间和服务时间由文件读入，形如右图所示。这个任务列表文件首先由程序生成，每秒一个任务达到，服务时间由{6,2,1,3,9}这个集合中的数据随机获取。文件列表要包含至少100个任务。
先要求实现如下要求的FCFS
当只有一个处理队列时的情况
当有两个处理队列时的情况

模拟实现SJF（短作业优先）

SJF算法首先调度已到达的任务中，服务时间最短的任务，这里不要求实现任务的抢占。
按照FCFS算法的要求实现SJF算法，同样要求处理两种情况：
当只有一个处理队列时的情况
当有两个处理队列时的情况

FCFS算法

    public class FCFS {
    private List<Process> processes;
    
    public FCFS(String fileString){
        processes = ProcessUtil.readProcesses(fileString);
    }
    
    public void execute(){
        ProcessUtil.sortByArrivalTime(processes);
        int currentTime = 0;
        for (int i = 0; i < processes.size(); i++) {
            System.out.println("时刻"+currentTime+": 进程"+processes.get(i).getProcessID()+"启动");
            if(processes.get(i).getArrivalTime()>=currentTime){
                processes.get(i).setStartingTime(processes.get(i).getArrivalTime());
                processes.get(i).setFinishingTime(processes.get(i).getStartingTime()+processes.get(i).getServiceTime());
                processes.get(i).setTurnAroundTime(processes.get(i).getFinishingTime()-processes.get(i).getArrivalTime());
                processes.get(i).setAverageTAT((double)processes.get(i).getTurnAroundTime() / processes.get(i).getServiceTime());
            }else {
                processes.get(i).setStartingTime(currentTime);
                processes.get(i).setFinishingTime(processes.get(i).getStartingTime()+processes.get(i).getServiceTime());
                processes.get(i).setTurnAroundTime(processes.get(i).getFinishingTime()-processes.get(i).getArrivalTime());
                processes.get(i).setAverageTAT((double)processes.get(i).getTurnAroundTime() / processes.get(i).getServiceTime());
            }
            currentTime = processes.get(i).getFinishingTime();
        }
        
        System.out.println("---------------------------------------------------------------------");

        ProcessUtil.sortByID(processes);
        for(Process p : processes){
            System.out.println(p);
        }
    }
}

SJF算法

    public class SJF {
    private List<Process> processes;

    // 从文件读入模拟进程
    public SJF(String fileString) {
        processes = ProcessUtil.readProcesses(fileString);
    }

    public void execute() {
        ProcessUtil.sortByServiceTime(processes);
        int currentTime = 0;  //起始时刻
        int next;
        while((next=nextVisit(currentTime))!=-1){
            System.out.println("时刻"+currentTime+": 进程"+processes.get(next).getProcessID()+"启动");
            processes.get(next).setStartingTime(currentTime);
            processes.get(next).setFinishingTime(processes.get(next).getServiceTime()+processes.get(next).getStartingTime());
            processes.get(next).setTurnAroundTime(processes.get(next).getFinishingTime()-processes.get(next).getArrivalTime());
            processes.get(next).setAverageTAT((double)processes.get(next).getTurnAroundTime() / processes.get(next).getServiceTime());
            currentTime = processes.get(next).getFinishingTime();
        }
        System.out.println("---------------------------------------------------------------------");
        ProcessUtil.sortByID(processes);
        for(Process p : processes){
            System.out.println(p);
        }
    }
    
    private int nextVisit(int currentTime) {
        for (int i = 0; i < processes.size(); i++) {
            if (processes.get(i).isVisited() == false && processes.get(i).getArrivalTime() < currentTime) {
                processes.get(i).setVisited(true);
                return i;
            }
        }
        return ProcessUtil.findFirstArrival(processes);   //先到达先执行;
    }
}

Process类

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