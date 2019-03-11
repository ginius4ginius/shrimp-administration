package com.ginius.shrimp_administration.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CLasse qui permet de valider le pattern des chaines de caractère
 * @author giniu
 *
 */
public class Validation {
	
	/**
	 * méthode qui valide le type composé de numérique.
	 * 
	 * @param text
	 * @return
	 */
	public static boolean errTypeInteger(String text) {
		
		String patterString = "[0-9]{2}";
		Pattern pattern = Pattern.compile(patterString);
		Matcher matcher = pattern.matcher(text);
		if (matcher.matches()) {
			return false;
		}
		return true;
	}

	/**
	 * méthode qui valide le type composé de numérique.
	 * 
	 * @param text
	 * @return
	 */
	public static boolean errTypeDouble(String text) {

		String patterString = "[0-9]{2}(\\.[0-9]{2})";
		Pattern pattern = Pattern.compile(patterString);
		Matcher matcher = pattern.matcher(text);
		if (matcher.matches()) {
			return false;
		}
		return true;

	}

}
