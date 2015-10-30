package pl.agh.edu.vending.interfaces;

/**
 * Holds all money which are earned by vending machine
 */
public interface Deposit {
	/**
	 * Adds money to the deposit
	 * @param moneyAmount
	 */
	void addMoney(int moneyAmount);
	
	/**
	 * GETS money from deposit(NOT AMOUNT BUT MONEY)
	 * @param moneyAmount which are to be withdrawn
	 * @return withdrawn money
	 */
	int getMoney(int moneyAmount);
	
	/**
	 * This function is being used in order to determine how much money is in deposit
	 * @return money amount in deposit
	 */
	int getMoneyAmount();
}
