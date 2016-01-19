
package controllers;

public class DiceGameFormController {
	Dice dice = new Dice();
	RollThreadHandler compRollThread = new RollThreadHandler(dice);
	RollThreadHandler playerRollThread = new RollThreadHandler(dice);
	private int wins = 0;
	private int losses = 0;

	public Die[] getRoll() {
		playerRollThread.start();
		playerRollThread.run();
		Die[] temp = playerRollThread.getCompDieArr();
		return temp;
	}

	public Die[] getReroll() {
		Die[] diceArr = dice.roll();
		return diceArr;
	}

	public Die[] getCompRoll() {
		compRollThread.start();
		compRollThread.run();
		Die[] temp = compRollThread.getCompDieArr();
		// temp=dice.computerRollLogic(temp);
		return temp;
	}

	public int[] getStatistics() {
		int z[] = dice.readFromFile();
		return z;
	}

	public void setStatistics(int compOrPlayer) {
		int[] z = getStatistics();
		if (compOrPlayer == 0) {
			z[0]++;
		} else if (compOrPlayer == 1) {
			z[1]++;
		}
		dice.writeToFile(z);
	}

}
