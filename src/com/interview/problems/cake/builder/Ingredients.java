package com.interview.problems.cake.builder;

/**
 * Ingredients Enum
 *
 * @author "Jigar Gosalia"
 *
 */
public enum Ingredients {
	FLOUR("f"), CREAM("c"), SUGAR("s"), PINEAPPLE("p"), CHERRIES("h"), STRAWBERRIES(
			"r"), COCOA("o");

	private String value;

	private Ingredients(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
