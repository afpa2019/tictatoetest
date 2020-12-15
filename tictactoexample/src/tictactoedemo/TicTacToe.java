package tictactoedemo;

/**
 *  class for demo tic tac toe game
 *
 */

public class TicTacToe {
	
	
	private char[][] tabJeu;
	private char markDeJeuCourant; // 'x' or 'o'

	public TicTacToe() {
		tabJeu = new char[3][3];
		 markDeJeuCourant = 'x';
		 initialiseTableau();

	}
	// Nous donne accès à markDeJeuCourant
	public char getMarkDeJeuCourant() {
		return markDeJeuCourant;
	}

	// initialise/réinitialise le tableau à des valeurs vides: '-'
	public void initialiseTableau() {

		// loop through rows
		for (int i = 0; i < 3; i++) {

			// loop through columns
			for (int j = 0; j < 3; j++) {
				tabJeu[i][j] = '-';
			}

		}

	}
      //affichage du tableau du jeu sur la sortie standard
	public void afficherTableau() {
		System.out.println("-------------");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++)
				System.out.print(tabJeu[i][j] + " | ");
			System.out.println();
			System.out.println("-------------");
		}

	}
	// Boucle à travers toutes les cellules du tableau et si l'une d'entre elles est vide (contient le caractère '-') alors renvoie false.
    // Sinon, le tableau est plein.
	public boolean isTabPlein() {
		 boolean isFull = true;

	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                if (tabJeu[i][j] == '-') {
	                    isFull = false;
	                }
	            }
	        }

	        return isFull;

	}
	// Renvoie true en cas d'un gain, false dans le cas contraire.
    // elle appelle les autres fonctions win check pour vérifier l'ensemble du tableau.
	public boolean verifierGain() {
		return (verifierlignesDeGain() || verifierColsDeGain() || verifierDiagonalsDeGain());

	}
	// Parcoure les lignes et voir si certaines d'entre elles sont gagnantes.
	private boolean verifierlignesDeGain() {
		 for (int i = 0; i < 3; i++) {
	            if (verifierLigneCol(tabJeu[i][0], tabJeu[i][1], tabJeu[i][2]) == true) {
	                return true;
	            }
	        }
		return false;

	}
	// Parcoure les colonnes et voir si certaines d'entre elles sont gagnantes.
	private boolean verifierColsDeGain() {
		for (int i = 0; i < 3; i++) {
            if (verifierLigneCol(tabJeu[0][i], tabJeu[1][i], tabJeu[2][i]) == true) {
                return true;
            }
        }
		return false;

	}
	//Vérifie les deux diagonales pour voir si l'une ou l'autre est gagnante. Renvoie true si l'une ou l'autre est gagnante
	private boolean verifierDiagonalsDeGain() {
	return((verifierLigneCol(tabJeu[0][0], tabJeu[1][1], tabJeu[2][2]) == true) || (verifierLigneCol(tabJeu[0][2], tabJeu[1][1], tabJeu[2][0]) == true));
	}
	
	// Vérifier si les trois valeurs sont identiques (et non vides) indiquant une victoire.
	private boolean verifierLigneCol(char c1, char c2, char c3) {
		return ((c1 != '-') && (c1 == c2) && (c2 == c3));
		

	}
	// Changer les marques du joueur de l'un à l'autre
    public void changeJoueur() {
        if (markDeJeuCourant == 'x') {
        	markDeJeuCourant = 'o';
        }
        else {
        	markDeJeuCourant = 'x';
        }
    }

    // Place une marque sur la cellule spécifiée par row et col avec la marque du joueur courant.
    public boolean placeMark(int row, int col) {

    	// Assure que la ligne et la colonne sont dans les limites du tableau.
        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (tabJeu[row][col] == '-') {
                    tabJeu[row][col] = markDeJeuCourant;
                    return true;
                }
            }
        }

        return false;
    }
}