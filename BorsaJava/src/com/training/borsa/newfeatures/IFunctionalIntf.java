package com.training.borsa.newfeatures;

@FunctionalInterface
public interface IFunctionalIntf {
	
	void execute();
	
	public default void test() {
		System.out.println("Test çaðrýldý");
	}
		
}
