package pl.agh.edu.vending.interfaces;

public interface Deposit {
	void addMoney(int moneyAmount);
	int getMoney(int moneyAmount);
	boolean isEnoughMoney(int moneyAmount);
	int getMoneyAmount();
}
