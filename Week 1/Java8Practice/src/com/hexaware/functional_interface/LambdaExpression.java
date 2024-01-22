package com.hexaware.functional_interface;

public class LambdaExpression {
	public static void main(String[] args) {
		MyInterface mi = (int a, int b) -> {return a+b;};
		System.out.println(mi.add(5, 5));
	}
}
