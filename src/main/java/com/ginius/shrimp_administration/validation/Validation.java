package com.ginius.shrimp_administration.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe qui permet de valider le pattern des chaines de caractère.
 * 
 * @author giniu
 *
 */
public class Validation {

	/**
	 * Méthode qui valide le type integer.
	 * 
	 * @param text
	 * @return
	 */
	public static boolean errTypeInteger(String text) {

		String patterString = "[0-9]{1,2}";
		Pattern pattern = Pattern.compile(patterString);
		Matcher matcher = pattern.matcher(text);
		if (matcher.matches()) {
			return false;
		}
		return true;
	}

	/**
	 * Méthode qui valide le type integer ou double.
	 * 
	 * @param text
	 * @return
	 */
	public static boolean errTypeIntegerOrDouble(String text) {

		String patterStringInteger = "[0-9]{1,2}";
		String patterStringDouble = "[0-9]{1,2}(\\.[0-9]{1,2})";
		Pattern patternInteger = Pattern.compile(patterStringInteger);
		Pattern patternDouble = Pattern.compile(patterStringDouble);
		Matcher matcherInteger = patternInteger.matcher(text);
		Matcher matcherDouble = patternDouble.matcher(text);
		if (matcherInteger.matches()) {
			return false;
		} else if (matcherDouble.matches()) {
			return false;
		}

		return true;

	}

}
