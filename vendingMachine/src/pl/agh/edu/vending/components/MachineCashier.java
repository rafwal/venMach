package pl.agh.edu.vending.components;

import pl.agh.edu.vending.interfaces.*;

public class MachineCashier implements Cashier{

	public static final int CACHE_CAPACITY = 1000;
	private int cache = 0;
	private MachineDeposit deposit = new MachineDeposit();
	
	@Override
	public void addMoneyToCache(int moneyAmount) {
		cache += moneyAmount;
	}

	@Override
	public int getMoneyAmountInCache() {
		return cache;
	}

	@Override
	public int giveOutMoneyInCache() {
		int tmp = cache;
		cache = 0;
		return tmp;
	}
	
	@Override
	public void passMoneyToDeposit(int moneyAmount){
		deposit.addMoney(moneyAmount);
		cache -= moneyAmount;
	}	
}
