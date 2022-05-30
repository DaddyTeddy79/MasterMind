package fr.teddy.mastermind;

public class KeyPeg {
	public static final int RIGHT_COLOR_RIGHT_PLACE = 2;
	public static final int RIGHT_COLOR_WRONG_PLACE = 1;
	public static final int WRONG_COLOR_WRONG_PLACE = 0;
	
	private int notation;
	
	public KeyPeg(int notation) {
		this.notation = notation;
	}
	
	public int getNotation() {
		return notation;
	}
}
