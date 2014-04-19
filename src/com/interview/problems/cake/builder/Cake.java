package com.interview.problems.cake.builder;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Product to be built
 *
 * @author "Jigar Gosalia"
 *
 */
public class Cake {

	/**
	 *
	 */
	private Set<String> cakeIngredients;

	/**
	 *
	 */
	private String qualityFactor;

	/**
	 *
	 */
	private Cake() {
		cakeIngredients = new LinkedHashSet<String>();
	}

	/**
	 * @param ingredients
	 */
	public Cake(final Ingredients... ingredients) {
		this();
		if (ingredients != null) {
			for (Ingredients ingredient : ingredients) {
				cakeIngredients.add(ingredient.getValue());
			}
			StringBuilder ingredientsConcat = new StringBuilder();
			for (String ingredient : cakeIngredients) {
				ingredientsConcat.append(ingredient);
			}
			qualityFactor = (QualityFactorHolder.getQualityFactorMap().get(
					ingredientsConcat.toString()) != null ? QualityFactorHolder
					.getQualityFactorMap().get(ingredientsConcat.toString())
					: QualityFactorHolder.getQualityFactorMap().get("NONE"));
		}
	}

	/**
	 * @return
	 */
	public Set<String> getCakeIngredients() {
		return cakeIngredients;
	}

	/**
	 * @return
	 */
	public String getQualityFactor() {
		return qualityFactor;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cake : Ingredients[" + Arrays.asList(cakeIngredients)
				+ "], QualityFactor[" + qualityFactor + "]";
	}
}
