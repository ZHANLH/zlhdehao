package me.ares.algorithms;

import java.util.List;
import me.ares.domain.Process;
import me.ares.utils.ProcessUtil;

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
