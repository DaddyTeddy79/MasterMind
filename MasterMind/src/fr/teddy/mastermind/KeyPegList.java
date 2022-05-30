package fr.teddy.mastermind;

import java.util.ArrayList;

public class KeyPegList {

	ArrayList<KeyPeg> keyPegs;

	public KeyPegList(CodePegCombination secretCode, CodePegCombination tryCombination) {

		keyPegs = new ArrayList<KeyPeg>();
		CodePegCombination secretCodeCopy = secretCode.getCopy();
		CodePegCombination tryCombinationCopy = tryCombination.getCopy();

		// Première boucle sur la combinaison d'essai pour les couleurs à la bonne place
		for (int index = 0; index < tryCombinationCopy.getSize(); index++) {

			CodePeg codePeg = tryCombinationCopy.getCodePeg(index);

			if (codePeg.isTheSameAs(secretCodeCopy.getCodePeg(index))) {
				keyPegs.add(new KeyPeg(KeyPeg.RIGHT_COLOR_RIGHT_PLACE));
				secretCodeCopy.nullifyCodePeg(index);
				tryCombinationCopy.nullifyCodePeg(index);
			}
		}

		// On refait une deuxième boucle pour les couleurs mal placées
		for (int index = 0; index < tryCombination.getSize(); index++) {

			CodePeg codePeg = tryCombinationCopy.getCodePeg(index);

			int tempIndex = secretCodeCopy.contains(codePeg);
			if (tempIndex != -1) {
				keyPegs.add(new KeyPeg(KeyPeg.RIGHT_COLOR_WRONG_PLACE));
				secretCodeCopy.nullifyCodePeg(tempIndex);
			}
		}
		
		// On ajoute les couleurs mal placées
		while (keyPegs.size() < secretCode.getSize()) {
			keyPegs.add(new KeyPeg(KeyPeg.WRONG_COLOR_WRONG_PLACE));
		}
	}

	public String printList() {
		String strList = "";
		for (KeyPeg keyPeg : keyPegs) {
			strList = strList + keyPeg.getNotation() + " ";
		}
		return strList;
	}

	public boolean everythingsRight() {
		for (KeyPeg kp : keyPegs) {
			if (kp.getNotation() != KeyPeg.RIGHT_COLOR_RIGHT_PLACE) {
				return false;
			}
		}
		return true;
	}
}
