package fr.teddy.mastermind;

import java.util.ArrayList;
import java.util.Random;

public class CodePegCombination {

	private ArrayList<CodePeg> combination;

	// This constructor generate the secret code
	public CodePegCombination(int codeSize, int numberOfDifferentsCodePegs, boolean onlyDifferentsCodePegs) {

		combination = new ArrayList<CodePeg>();
		while (combination.size() < codeSize) {

			CodePeg newCodePeg = new CodePeg(numberOfDifferentsCodePegs);

			if (onlyDifferentsCodePegs) {
				boolean alreadyInCombination = false;
				for (CodePeg peg : combination) {
					if (newCodePeg.equals(peg)) {
						alreadyInCombination = true;
						break;
					}
				}
				if (!alreadyInCombination) {
					combination.add(newCodePeg);
				}
				else newCodePeg = null;
			} 
			else 
				combination.add(newCodePeg);
		}
	}
	
	public CodePegCombination(String tryCode) {
		combination = new ArrayList<CodePeg>();
		for (int index = 0 ; index < tryCode.length() ; index++) {
			CodePeg newCodePeg = new CodePeg(tryCode.charAt(index));
			combination.add(newCodePeg);
		}
	}
	
	// This construction enables cloning
	public CodePegCombination(ArrayList<CodePeg> clone) {
		combination = clone;
	}
	
	public ArrayList<CodePeg> getCombination() {
		return combination;
	}
	
	public int getSize() {
		return combination.size();
	}

	public String printCode() {
		String strCode = "";
		for (CodePeg peg : combination) {
			strCode = strCode + peg.printCodePeg() + " ";
		}
		return strCode;
	}

	public CodePeg getCodePeg(int index) {
		return combination.get(index);
	}
	
	// This method is only used for cloned combination
	public void nullifyCodePeg(int index) {
		combination.set(index, null);
	}

	public CodePegCombination getCopy() {
		ArrayList<CodePeg> copy = (ArrayList<CodePeg>) combination.clone();
		CodePegCombination copiedCombination = new CodePegCombination(copy);
		return copiedCombination;
	}

	public int contains(CodePeg codePeg) {
		for (int index = 0 ; index < combination.size(); index++) {
			CodePeg cp = combination.get(index);
			if (cp != null && cp.isTheSameAs(codePeg)) {
				return index;
			}
		}
		return -1;
	}
}
