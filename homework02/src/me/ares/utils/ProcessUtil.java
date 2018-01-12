package me.ares.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import me.ares.domain.Process;

public class ProcessUtil {
    
    public static List<Process> readProcesses(String fileString){
        List<Process> processes = new ArrayList<Process>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileString));
            while (scanner.hasNext()) {
                char processID = scanner.next().charAt(0);
                int arrivalTime = scanner.nextInt();
                int serviceTime = scanner.nextInt();
                processes.add(new Process(processID, arrivalTime, serviceTime));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner.close();
        return processes;
    }
    
    public static void sortByServiceTime(List<Process> processes) {
        processes.sort(new Comparator<Process>() {
            public int compare(Process o1, Process o2) {
                if (o1.getServiceTime() > o2.getServiceTime()) {
                    return 1;
                } else if (o1.getServiceTime() == o2.getServiceTime()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
    }
    
    public static void sortByID(List<Process> processes) {
        processes.sort(new Comparator<Process>(){

            @Override
            public int compare(Process o1, Process o2) {
                if (o1.getProcessID()>o2.getProcessID()) {
                    return 1;
                }else if (o1.getProcessID() == o2.getProcessID()) {
                    return 0;
                }else{
                    return -1;
                }
            }
            
        });
    }
    
    public static void sortByArrivalTime(List<Process> processes){
        processes.sort(new Comparator<Process>() {

            @Override
            public int compare(Process o1, Process o2) {
                if(o1.getArrivalTime()>o2.getArrivalTime()) return 1;
                else if (o1.getArrivalTime()==o2.getArrivalTime()) return 0; 
                else return -1;
            }
        });
    }
    
    public static int findFirstArrival(List<Process> processes) {
        int firstArrival = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < processes.size(); i++) {
            if (processes.get(i).isVisited() == false
                    && processes.get(i).getArrivalTime() < firstArrival) {
                firstArrival = processes.get(i).getArrivalTime();
                index = i;
            }
        }
        if (index != -1)
            processes.get(index).setVisited(true); // index值改变代表进程被找到，设置进程visited值
        return index;
    }
    
}