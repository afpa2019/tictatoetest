package demo;

import java.util.Scanner;


/**
 * demo tic tac toe game position, helpful indices 
 * [1][1], [1][2], [1][3]
 * [2][1], [2][2], [2][3]
 * [3][1], [3][2], [3][3]
 * 
 *  To play enter two indices from table above without brackets in standard input for example: 1 1 there must be a space between two indices
 *
 */

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		TicTacToe game = new TicTacToe();
		game.initialiseTableau();
		System.out.println("Tic-Tac-Toe!");
		do {
			System.out.println("Disposition actuelle du tableau:");
			game.afficherTableau();
			int row;
			int col;
			do {
				System.out.println("Joueur " + game.getMarkDeJeuCourant()
					+ " entrez deux indices dans une cellule vide pour placer votre marque!");
				row = scan.nextInt() - 1;
				col = scan.nextInt() - 1;
				
			} while (!game.placeMark(row, col));
			game.changeJoueur();
			
		} while (!game.verifierGain() && !game.isTabPlein());
		
		if (game.isTabPlein() && !game.verifierGain()) {
			System.out.println("Le jeu est à égalité!");
		} else {
			System.out.println("Disposition actuelle du tableau:");
			game.afficherTableau();
			game.changeJoueur();
			System.out.println(Character.toUpperCase(game.getMarkDeJeuCourant()) + " Wins!");
		}
		scan.close();
	}
     
}
