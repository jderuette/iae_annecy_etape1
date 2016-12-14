/**
 * 
 */

package org.iae.annecy.st1.tools;

import java.util.Scanner;

/**
 * Classe utilitaire pour gérer les intéraction utilisateur via une console.
 * 
 * @author Djer1013
 */
public final class ConsoleHelper {

	public ConsoleHelper() {

	}

	/**
	 * Affiche une message dans la console.
	 * 
	 * @param message
	 *            le message à afficher à l'utilisateur
	 */
	
	public static void display(final String message) {
		System.out.println(message);
	}

	/**
	 * Pose une question a l'utilisateur et renvoie la valeur saisies
	 * 
	 * @param source
	 *            : l'endroit ou il faut lire les données
	 * @param question
	 *            : question a poser à l'tilisateur
	 * @return une chaine de texte saisie par l'utilsateur
	 */
	public static String read(final Scanner source, final String question) {
		String input = null;
		if (null != question) {
			display(question);
		}
		while (source.hasNextLine()) {
			input = source.nextLine();
			if (input != null) {
				break;
			}
		}
		return input;
	}
	
	/**
	 * Pose une question a l'utilisateur et renvoie la valeur saisie
	 * 
	 * @param source
	 *            : l'endroit ou il faut lire les données
	 * @param question
	 *            : question a poser à l'tilisateur
	 * @return un nombre saisit par l'utilsateur
	 */
	public static Integer readInt(final Scanner source, final String question) {
		Integer input = 0;
		if (null != question) {
			display(question);
		}
		while (source.hasNextInt()) {
			input = source.nextInt();
			if (input != null) {
				break;
			}
		}
		return input;
	}

	/**
	 * Lit ce qui a été saisie par l'utilisateur.
	 * 
	 * @param source
	 *            : l'endroit ou il faut lire les données
	 * @return une chaine de texte saisie par l'utilsateur
	 */
	public static String read(final Scanner source) {
		return read(source, null);
	}
	
	/**
	 * Lit ce qui a été saisie par l'utilksateur.
	 * 
	 * @param source
	 *            : l'endroit ou il faut lire les données
	 * @return un nombre saisit par l'utilsateur
	 */
	public static Integer readInt(final Scanner source) {
		return readInt(source, null);
	}
	
}
