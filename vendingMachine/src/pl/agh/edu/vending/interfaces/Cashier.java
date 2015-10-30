package pl.agh.edu.vending.interfaces;

/**
 * Class implementing this interface should be responsible for managing money DURING TRANSACTIONS.
 * Class could have cache money value, which is money tossed in by client while buying product.
 * After purchase money are being transported to deposit.It is indicated that class implementing this 
 * interface should aggregate class implementing deposit interface. That is why there is function
 * <b>passMoneyToDeposit</b>. Only cashier can manage all money in the machine.  
 */
public interface Cashier {
	
	/**
	 * Adds money tossed into the machine by client to the money cache
	 * @param moneyAmount - money tossed in by user
	 */
	void addMoneyToCache(int moneyAmount);
	
	/**
	 * INFORMS how much money is being held in cache(NOT DEPOSIT)
	 * @return money amount in cache
	 */
	int getMoneyAmountInCache();
	
	/**
	 * RETURNS money in cache to user, should be use when client want to get all money back
	 * or when returning change
	 * @return money amount in cache which is being given out
	 */
	int giveOutMoneyInCache();
	
	/**
	 * After transaction transports money in cache to deposit
	 * @param moneyAmount amount to transport
	 */
	void passMoneyToDeposit(int moneyAmount);
}
