package com.interview.problems.cake.builder;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author "Jigar Gosalia"
 *
 */
public class QualityFactorHolder {

	/**
	 *
	 */
	private static Map<String, String> qualityFactorMap = new LinkedHashMap<String, String>();

	/**
	 * @return
	 */
	public static Map<String, String> getQualityFactorMap() {
		return qualityFactorMap;
	}

	// Static Block to have pre-defined quality factors
	static {
		qualityFactorMap.put("fco", "1");
		qualityFactorMap.put("ocf", "2");
		qualityFactorMap.put("cfo", "3");
		qualityFactorMap.put("cof", "4");
		qualityFactorMap.put("ofc", "5");
		qualityFactorMap.put("foc", "6");
		qualityFactorMap.put("ocsrf", "7");
		qualityFactorMap.put("focsr", "8");
		qualityFactorMap.put("fcosr", "9");
		qualityFactorMap.put("fcsor", "10");
		qualityFactorMap.put("chf", "11");
		qualityFactorMap.put("NONE", "New Combination, so no quality factor found");
	}
}
