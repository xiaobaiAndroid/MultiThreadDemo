package com.bzf.multithreadeddemo;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeadLockTest {

    @Test
    public void testDeadLock(){
        new DeadLock().deadLock();
    }

}