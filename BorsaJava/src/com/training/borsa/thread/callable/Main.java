package com.training.borsa.thread.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
	public static void main(String[] args) {
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		MyCallable callable = new MyCallable();
		Future<String> result = newCachedThreadPool.submit(callable);
		
		try {
			String string = result.get();
			System.out.println("Main Thread : " + string);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
