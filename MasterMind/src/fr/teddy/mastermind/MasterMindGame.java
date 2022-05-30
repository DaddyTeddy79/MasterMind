package fr.teddy.mastermind;

import java.util.ArrayList;
import java.util.Scanner;

public class MasterMindGame {

	// taille du code secret
	static int secretCodeSize;
	// nombre de couleurs
	static int numberOfDifferentsCodePegs;
	// nombre de tentatives maximum
	static int maxTryNumber = 0;
	// le code secret contient-il uniquement des couleurs différentes ?
	static boolean onlyDifferentsCodePegs = true;
	// combinaison secrète
	static CodePegCombination secretCode;
	// liste de tous les essais
	static ArrayList<TryLine> gameBoard;

	public static void main(String[] args) {
		// configuration de base
		secretCodeSize = 5;
		numberOfDifferentsCodePegs = 8;
		startGame();
	}

	public static void startGame() {

		System.out.println("***************************");
		System.out.println("Bienvenue dans Mastermind !");
		System.out.println("***************************");
		// A INPLEMENTER : choix du nombre de "couleurs" possibles, de la taille du code
		// et du nombre maximal d'essais
		generateSecretCode();
		secretCode.printCode();
		boolean gameOver = false;
		gameBoard = new ArrayList<TryLine>();
		int tryNumber = 0;
		Scanner sc = new Scanner(System.in);
		while (!gameOver) {
			System.out.println("Entrez votre proposition de code secret:");
			String tryCode = sc.nextLine();
			tryNumber++;
			CodePegCombination tryCombination = new CodePegCombination(tryCode);
			KeyPegList keyPegList = new KeyPegList(secretCode, tryCombination);
			TryLine tryLine = new TryLine(tryNumber, tryCombination, keyPegList);
			gameBoard.add(tryLine);
			tryCombination.printCode();
			keyPegList.printList();
			gameOver = keyPegList.everythingsRight();
			System.out.println(" ");
			displayGameBoard();
			System.out.println("***************************");
		}
		System.out.println("Bravo !");
		sc.close();
	}

	private static void displayGameBoard() {
		for (TryLine tryLine : gameBoard) {
			tryLine.printTry();
		}
	}

	public static void generateSecretCode() {
		secretCode = new CodePegCombination(secretCodeSize, numberOfDifferentsCodePegs, onlyDifferentsCodePegs);
	}
}
	

