package com.training.borsa.newfeatures;

public class MainInterface {
	public static void main(String[] args) {
		String myName = "Osman";
		
		IMyInterface myInterface = new IMyInterface() {
			
			@Override
			public void execute() {
				test(myName);
			}
		};
	}
}
