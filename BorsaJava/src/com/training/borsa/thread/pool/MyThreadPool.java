package com.training.borsa.thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class MyThreadPool {
	private BlockingQueue<Runnable> myQueue = new ArrayBlockingQueue(1000);
	
	public Runnable getNext() throws InterruptedException {
		return myQueue.take();
	}
	
	public void add(Runnable runnable) {
		myQueue.add(runnable);
	}
}
