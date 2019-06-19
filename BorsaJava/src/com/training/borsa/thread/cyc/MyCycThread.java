package com.training.borsa.thread.cyc;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class MyCycThread extends Thread{
	private CyclicBarrier barrier;
	
	
	public MyCycThread(CyclicBarrier barrier) {
		super();
		this.barrier = barrier;
	}


	@Override
	public void run() {
		try {
			Thread.sleep(new SecureRandom().nextInt(30_000));
			barrier.await();
			Thread.sleep(new SecureRandom().nextInt(30_000));
			barrier.await();
			Thread.sleep(new SecureRandom().nextInt(30_000));
			barrier.await();
			barrier.reset();
		} catch (Exception e) {
		}
	}
}
