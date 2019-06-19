package com.training.borsa.thread.pool;

public class MyThreadRunner extends Thread {
	private MyThreadPool myThreadPool;
	private int index;

	public MyThreadRunner(MyThreadPool myThreadPool,int index) {
		this.myThreadPool = myThreadPool;
		this.index = index;
		this.setName("MyThreadRunner-" + index);
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Runnable next = myThreadPool.getNext();
				next.run();
				if (this.isInterrupted()) {
					break;
				}
			} catch (InterruptedException e) {
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
