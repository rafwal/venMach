package pl.agh.edu.vending.components;

import pl.agh.edu.vending.interfaces.*;

public class MachineDeposit implements Deposit{

	private int moneyAmount = 1000;
	
	@Override
	public void addMoney(int moneyAmount) {
		this.moneyAmount += moneyAmount;
		
	}

	@Override
	public int getMoney(int moneyAmount) {
		this.moneyAmount -= moneyAmount;
		return moneyAmount;
	}

	@Override
	public boolean isEnoughMoney(int moneyAmount) {
		return this.moneyAmount>moneyAmount;
	}

	@Override
	public int getMoneyAmount() {
		return this.moneyAmount;
	}

}
