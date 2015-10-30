package pl.agh.edu.vending.interfaces;


/**
 * @author Rafal W
 * Class implementing this interface should be respansible
 * for getting input from user for Vending Machine. This interface
 * contains methods for client purpose, therefore there is no method 
 * which is accepting input for actions like changing products quantity
 * or adding new ones.
 */
public interface UserInput {

	
	/**
	 * Request when client toss in money into the machine   
	 */
	int TOSS_IN_MONEY = -1;
	
	/**
	 * Request when client wants to get his/her money back  
	 */
	int GIVE_OUT_MONEY = -2;
	/**
	 * Request when client decides to type products code
	 */
	int ENTER_THE_CODE = -3;
	/**
	 * Request when client whant to see the list of products
	 */
	int LIST_PRODUCTS = -4;
	/**
	 * If there appear an errar in input that value is being returned
	 */
	int INVALID_INPUT = -5;
	
	/**
	 * When client decides to leave
	 */
	int EXIT = -6;
	
	
	/**
	 * This method accepts an input from user and process it into one of the interface's request
	 * @return one of the requests from the interface
	 */
	int getRequestAsClient();
	/**
	 * This method accepts input from user representing product's code
	 * @return code of the product
	 */
	int getProductCode();
	/**
	 * This method accepts input from user representing money amount
	 * which the user want to toss into the machine
	 * @return amount of money which user tossed into the machine
	 */
	int getMoneyAmount();
}
