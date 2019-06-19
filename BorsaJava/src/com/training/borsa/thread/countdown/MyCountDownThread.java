package com.training.borsa.thread.countdown;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class MyCountDownThread extends Thread {
	private CountDownLatch countDownLatch;
	public MyCountDownThread(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(new Random().nextInt(30_000));
			countDownLatch.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
