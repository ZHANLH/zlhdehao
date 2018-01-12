package me.ares.junittest;

import me.ares.algorithms.SJF;

import org.junit.Test;

public class SJF_Test {
    SJF sjf = new SJF("test.txt");

    @Test
    public void testExecute() {
        
        sjf.execute();
    }

}