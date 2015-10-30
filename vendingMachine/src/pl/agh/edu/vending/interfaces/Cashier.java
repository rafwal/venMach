package pl.agh.edu.vending.interfaces;

public interface Cashier {
	void addMoneyToCache(int moneyAmount);
	int getMoneyAmountInCache();
	int giveOutMoneyInCache();
	void passMoneyToDeposit(int moneyAmount);
}
