package com.bzf.multithreadeddemo;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreadInterruptTest {

    @Test
    public void interruptThread() {
        new ThreadInterrupt().interruptThread();
    }
}