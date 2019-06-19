package com.training.borsa.enumtest;

public enum STATUS {
	ACTIVE("actif"),PASSIVE("pasif"){
		@Override
		public void test() {
			System.out.println("Pasif test");
		}
	};
	
	private String desc;

	private STATUS(String desc) {
		this.desc = desc;
	}
	
	public void test() {
		System.out.println("Test called");
	}
}
