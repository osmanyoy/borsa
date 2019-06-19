package com.training.borsa.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MyCallable implements Callable<String>{

	@Override
	public String call() throws Exception {
		try {
			Thread.sleep(1000);
//			Thread.yield();
//			TimeUnit.SECONDS.sleep(10);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "Test String";
	}

}
