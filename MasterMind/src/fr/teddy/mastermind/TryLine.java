package fr.teddy.mastermind;

public class TryLine {
	private int tryNumber;
	private CodePegCombination tryCombinaison;
	private KeyPegList keyPegList;
	
	public TryLine (int tryNumber, CodePegCombination tryCombinaison, KeyPegList keyPegList) {
		this.tryNumber = tryNumber;
		this.tryCombinaison = tryCombinaison;
		this.keyPegList = keyPegList;
	}
	
	public void printTry() {
		System.out.println("Essai n°" + tryNumber + " : " + tryCombinaison.printCode() + " | " + keyPegList.printList());
	}
}
