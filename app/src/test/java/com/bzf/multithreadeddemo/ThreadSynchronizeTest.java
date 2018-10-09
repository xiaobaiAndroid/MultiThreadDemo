package com.bzf.multithreadeddemo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ThreadSynchronizeTest {

    private ThreadSynchronize ts;

    @Before
    public void setUp() throws Exception {
        ts = new ThreadSynchronize();

    }

    @Test
    public void testLock() {
        ts.testLock();
    }

    @Test
    public void testSynchronize(){
        ts.testSynchronize();
    }

    @Test
    public void testSynchronizePiece(){
        ts.testSynchronizePiece();
    }
}