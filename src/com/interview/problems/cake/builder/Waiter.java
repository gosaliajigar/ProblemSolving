package com.interview.problems.cake.builder;

/**
 * Main Processor
 *
 * @author "Jigar Gosalia"
 *
 */
public class Waiter {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		Cake chocolateCake = new Cake(Ingredients.FLOUR, Ingredients.COCOA, Ingredients.CREAM);
		CakeBuilder.buildCake(chocolateCake);
		System.out.println("-------------------------");
		Cake cherryCake = new Cake(Ingredients.FLOUR, Ingredients.CHERRIES, Ingredients.CREAM);
		CakeBuilder.buildCake(cherryCake);
	}
}
