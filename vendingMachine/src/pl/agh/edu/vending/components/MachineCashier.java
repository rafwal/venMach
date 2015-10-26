package pl.agh.edu.vending.components;

import pl.agh.edu.vending.interfaces.*;

public class MachineCashier implements Cashier{

	private int cache = 0;
	private MachineDeposit deposit = new MachineDeposit();
	
	@Override
	public void addMoneyToCache(int moneyAmount) {
		cache += moneyAmount;
	}

	@Override
	public int getMoneyInCache() {
		return cache;
	}

	@Override
	public int giveOutMoneyInCache() {
		int tmp = cache;
		cache = 0;
		return tmp;
	}

	@Override
	public int purchaseAndGiveOutChange(int price) {
		passMoneyToDeposit(price);
		int change = cache;
		cache = 0;
		return change;
	}
	

	private void passMoneyToDeposit(int moneyAmount){
		deposit.addMoney(moneyAmount);
		cache -= moneyAmount;
	}
	
}
