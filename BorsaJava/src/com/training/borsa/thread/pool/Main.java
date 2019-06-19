package com.training.borsa.thread.pool;

public class Main {
	public static void main(String[] args) {
		MyThreadPool myThreadPool = new MyThreadPool();
		for (int i = 0; i < 5; i++) {
			MyThreadRunner myThreadRunner = new MyThreadRunner(myThreadPool, i);
			myThreadRunner.start();
		}
		
		for (int i = 0; i < 10_000; i++) {
			myThreadPool.add(new Runnable() {
				@Override
				public void run() {
					System.out.println("Run me");
				}
			});
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
		}
	}
}
