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
	 * Constructeur private pour empecher d'instancier la classe qui n'est qu'un
	 * utilitaire de méthodes abstraites
	 */
	private Validation() {

	}

	/**
	 * Méthode qui valide le type integer.
	 * 
	 * @param text
	 * @return
	 */
	public static boolean errTypeInteger(String text) {

		boolean result = true;

		String patterString = "[0-9]{1,2}";
		Pattern pattern = Pattern.compile(patterString);
		Matcher matcher = pattern.matcher(text);
		if (matcher.matches()) {
			result = false;
		}
		return result;

	}

	/**
	 * Méthode qui valide le type integer ou double.
	 * 
	 * @param text
	 * @return
	 */
	public static boolean errTypeIntegerOrDouble(String text) {

		boolean result = true;

		String patterStringInteger = "[0-9]{1,2}";
		String patterStringDouble = "[0-9]{1,2}(\\.[0-9]{1,2})";
		Pattern patternInteger = Pattern.compile(patterStringInteger);
		Pattern patternDouble = Pattern.compile(patterStringDouble);
		Matcher matcherInteger = patternInteger.matcher(text);
		Matcher matcherDouble = patternDouble.matcher(text);
		if (matcherInteger.matches() || matcherDouble.matches()) {
			result = false;
		}
		return result;

	}

}
