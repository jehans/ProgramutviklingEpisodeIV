package com.theforce.programutviklingsepisodeIV;

import java.util.MissingResourceException;

import java.util.ResourceBundle;

/**
 * Class used for internationalization
 * Supports Norwegian and Standard language(English)
 * 
 * @author Hans Martin Bragen
 * @author John Hoegh-Omdal
 * @author Jehans Storvik
 */
public class Messages {
	private static final String BUNDLE_NAME = "com.theforce.programutviklingsepisodeIV.lang.messages"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private Messages() {}
	/**
	 * @param key with the textcode to be translated
	 * @return Returns the String in the system language
	 */
	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}