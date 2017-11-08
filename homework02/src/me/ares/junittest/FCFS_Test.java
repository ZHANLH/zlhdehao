package me.ares.junittest;

import me.ares.algorithms.FCFS;
import org.junit.Test;

public class FCFS_Test {

    FCFS fcfs = new FCFS("test.txt");
    
    @Test
    public void testExecute() {
        fcfs.execute();
    }

}