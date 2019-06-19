package com.training.borsa.newfeatures;

public interface IMyInterface {
	
	public default void test(String name) {
		System.out.println("hello world " + name) ;
	}
	
	public void execute();
}
