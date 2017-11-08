package me.ares.algorithms;

import java.util.List;
import me.ares.domain.Process;
import me.ares.utils.ProcessUtil;

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
