package pl.agh.edu.vending.interfaces;

public interface Cashier {
	void addMoneyToCache(int moneyAmount);
	int getMoneyInCache();
	int giveOutMoneyInCache();
	int purchaseAndGiveOutChange(int price);
}
