package com.training.borsa.newfeatures;

public class MainCalculation {
	public static void main(String[] args) {
		int calc = calc((g, h) -> g + h, 10, 20);
		System.out.println("Sonuç " + calc);

		int calc2 = calc((g, h) -> g - h, 10, 20);
		System.out.println("Sonuç " + calc2);

	}

	public static int calc(ICalculation ical, int x, int y) {
		return ical.calculate(x, y);
	}
}
