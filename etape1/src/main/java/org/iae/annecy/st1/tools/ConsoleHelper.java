/**
 * 
 */

package org.iae.annecy.st1.tools;

import org.iae.annecy.st1.etape1.view.menu.MenuView;

/**
 * Classe utilitaire pour gérer les intération utilisateur via une console.
 * 
 * @author Djer1013
 */
public final class ConsoleHelper {

    	static MenuView menu = new MenuView();
	private ConsoleHelper() {

	}

	/**
	 * Affiche une message dans la console.
	 * 
	 * @param mesage
	 *            le message à afficher à l'utilisateur
	 */
	public static void display(final String mesage) {
	    menu.utilAff(mesage);
	}
}
