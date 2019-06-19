package com.training.borsa.newfeatures;

public class MainLambda {
	public static class MyIntfClass implements IFunctionalIntf{
		
		@Override
		public void execute() {
			System.out.println("Merhaba Osman");
			test();
		}
		
	}
	public static void main(String[] args) {
		String myName = "Osman";

//		IFunctionalIntf il = () -> System.out.println("hello world " + myName );
//		il.execute();

		MainLambda.runner(() -> System.out.println("hello world " + myName));
		MainLambda.runner(() -> System.out.println("Merhaba " + myName));
		MainLambda.runner(() -> {
			System.out.println("Merhaba " + myName);
			System.out.println("Hola " + myName);
			// test(); -> Yanlýþ
		});
		
		MainLambda.runner(new IFunctionalIntf() {
			
			@Override
			public void execute() {
				System.out.println("Merhaba " + myName);
				test();
			}
		});

		MainLambda.runner(new MyIntfClass());
	}

	public static void runner(IFunctionalIntf il) {
		il.execute();
	}
}
