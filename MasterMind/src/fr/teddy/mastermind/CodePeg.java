package fr.teddy.mastermind;

import java.util.Random;

public class CodePeg {

	/*private PegColor pegColor;

	public CodePeg(PegColor color) {
		pegColor = color;
	}
	
	public PegColor getPegColor() {
		return pegColor;
	}
	*/
	
	private char character;
	
	public CodePeg(int numberOfDifferentsCodePegs) {

		Random random = new Random();
		int randomChar = random.nextInt(numberOfDifferentsCodePegs);
		character = (char) (randomChar + 65);
	}
	
	public CodePeg(char c) {
		character = c;
	}
	
	public char getCharacter() {
		return character;
	}

	public char printCodePeg() {
		return character;
	}
	
	public boolean isTheSameAs(CodePeg otherCodePeg) {
		if (this == null || otherCodePeg == null) {
			return false;
		}
		else if (this.character == otherCodePeg.getCharacter()) {
			return true;
		}
		else return false;
	}
	
	public boolean equals(CodePeg comparedCodePage) {
		if (comparedCodePage.getCharacter() == this.character)
			return true;
		else 
			return false;
	}
}