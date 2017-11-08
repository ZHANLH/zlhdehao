---
title: JAVAʵ��4 

ģ��ʵ��FCFS�������ȷ����㷨-1

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

ģ��ʵ��FCFS�������ȷ����㷨-2

����(Task)��ID����ʼʱ��ͷ���ʱ�����ļ����룬������ͼ��ʾ����������б��ļ������ɳ������ɣ�ÿ��һ������ﵽ������ʱ����{6,2,1,3,9}��������е����������ȡ���ļ��б�Ҫ��������100������
��Ҫ��ʵ������Ҫ���FCFS
��ֻ��һ���������ʱ�����
���������������ʱ�����

ģ��ʵ��SJF������ҵ���ȣ�

SJF�㷨���ȵ����ѵ���������У�����ʱ����̵��������ﲻҪ��ʵ���������ռ��
����FCFS�㷨��Ҫ��ʵ��SJF�㷨��ͬ��Ҫ�������������
��ֻ��һ���������ʱ�����
���������������ʱ�����

FCFS�㷨

    public class FCFS {
    private List<Process> processes;
    
    public FCFS(String fileString){
        processes = ProcessUtil.readProcesses(fileString);
    }
    
    public void execute(){
        ProcessUtil.sortByArrivalTime(processes);
        int currentTime = 0;
        for (int i = 0; i < processes.size(); i++) {
            System.out.println("ʱ��"+currentTime+": ����"+processes.get(i).getProcessID()+"����");
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

SJF�㷨

    public class SJF {
    private List<Process> processes;

    // ���ļ�����ģ�����
    public SJF(String fileString) {
        processes = ProcessUtil.readProcesses(fileString);
    }

    public void execute() {
        ProcessUtil.sortByServiceTime(processes);
        int currentTime = 0;  //��ʼʱ��
        int next;
        while((next=nextVisit(currentTime))!=-1){
            System.out.println("ʱ��"+currentTime+": ����"+processes.get(next).getProcessID()+"����");
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
        return ProcessUtil.findFirstArrival(processes);   //�ȵ�����ִ��;
    }
}

Process��

    package me.ares.domain;
    public class Process {
    private char processID;
    private int arrivalTime;   //����ʱ��
    private int serviceTime;   //����ʱ��
    private int startingTime; //��ʼʱ��
    private int finishingTime; //���ʱ��
    private int turnAroundTime; //��תʱ��
    private double averageTAT;  //��Ȩ��תʱ��
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