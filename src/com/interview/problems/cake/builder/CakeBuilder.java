package com.interview.problems.cake.builder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * Cake Builder
 *
 * @author "Jigar Gosalia"
 *
 */
public class CakeBuilder {

	/**
	 * @param cake
	 */
	public static void buildCake(final Cake cake) {
		System.out.println("Cake is ready ... ");
		System.out.println();
		System.out.println(cake.toString());
		System.out.println();
		getRecommendedQualityFactor(cake.getCakeIngredients());
	}

	/**
	 * Get Recommended Quality Factor for the ingredients given
	 *
	 * @param ingredients
	 */
	public static void getRecommendedQualityFactor(final Set<String> ingredients) {

		Set<String> possiblePermutations = getPermutations(getContent(ingredients));

		Map<String, String> sortedRecommendations = new TreeMap<String, String>();

		if (possiblePermutations.size() > 0) {
			for (String permutation : possiblePermutations) {
				if (!permutation.equals(getContent(ingredients))
						&& QualityFactorHolder.getQualityFactorMap().get(
								permutation) != null) {
					sortedRecommendations.put(QualityFactorHolder
							.getQualityFactorMap().get(permutation),
							permutation);
				}
			}
		}

		if (sortedRecommendations.size() > 0) {
			System.out.println("Recommendations :");
			for (Entry<String, String> entry : sortedRecommendations.entrySet()) {
				System.out.println(entry.getValue() + " : " + entry.getKey());
			}
		} else {
			System.out
					.println("No recommendations at this time with ingredients : "
							+ Arrays.asList(ingredients));
		}
	}

	/**
	 * Recursively get permutations of the inputString
	 *
	 * @param inputString
	 * @return
	 */
	public static Set<String> getPermutations(String inputString) {
		Set<String> permutationSet = new HashSet<String>();
		// Breaking condition
		if (inputString == "")
			return permutationSet;
		Character firstChar = inputString.charAt(0);
		if (inputString.length() > 1) {
			inputString = inputString.substring(1);
			// recursive call
			Set<String> recursivePermutationSet = getPermutations(inputString);
			for (String permutation : recursivePermutationSet) {
				for (int i = 0; i <= permutation.length(); i++) {
					permutationSet.add(permutation.substring(0, i) + firstChar
							+ permutation.substring(i));
				}
			}
		} else {
			permutationSet.add(firstChar + "");
		}
		return permutationSet;
	}

	/**
	 * Concatenate the Set of ingredients into a string
	 *
	 * @param ingredients
	 * @return
	 */
	public static String getContent(final Set<String> ingredients) {
		StringBuilder content = new StringBuilder();
		for (String ingredient : ingredients) {
			content.append(ingredient);
		}
		return content.toString();
	}
}
