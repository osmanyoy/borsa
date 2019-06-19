package com.training.borsa.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

	private static long counter;
	private long counter2;
	private long counter3;
	private Object object = new Object();
	
	private long counter4;
	private ReentrantLock lock = new ReentrantLock(true);
	
	private long counter5;	
	private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	
	private AtomicLong counter6 = new AtomicLong();

	private AtomicBoolean atomicBoolean = new AtomicBoolean(true);
	
	public void booleanUsage() {
		boolean compareAndSet = atomicBoolean.compareAndSet(false, true);
		
	}
		
	public void increase6() {
		counter6.incrementAndGet();
	}

	public void increase5() {
		readWriteLock.writeLock().lock();
		try {
			counter5 ++;
		} finally {
			readWriteLock.writeLock().unlock();
		}
	}
	
	public long getCounter5() {
		readWriteLock.readLock().lock();
		try {
			return counter5 ;
		} finally {
			readWriteLock.readLock().unlock();
		}
	}
	
	public void increase4() {
		lock.lock();
		try {
			counter4 ++;
		} finally {
			lock.unlock();
		}
	}

	public static  void increase() {
		synchronized(Main.class) {
			counter++;
		}
	}
	
	public void increase2() {
		synchronized(this) {
			counter2++;
		}
	}

	public void increase3() {
		synchronized(object) {
			counter3++;
		}
	}

	public static void main(String[] args) {
		
		MyThread[] myThreadArr = new MyThread[5];
		
		for (int i = 0; i < 5; i++) {
			MyThread myThread = new MyThread();
			myThread.start();
			myThreadArr[i] = myThread;
		}
		for (int i = 0; i < 5; i++) {
			try {
				myThreadArr[i].join();
			} catch (InterruptedException e) {
			}
		}
		
		MyRunable myRunable = new MyRunable();
		Thread thread = new Thread(myRunable);
		thread.start();
		
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
		newFixedThreadPool.execute(myRunable);
			
		System.out.println("Thread run success : " + counter);
	}
}
