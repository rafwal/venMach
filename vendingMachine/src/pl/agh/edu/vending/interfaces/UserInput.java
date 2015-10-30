package pl.agh.edu.vending.interfaces;

public interface UserInput {

	int TOSS_IN_MONEY = -1;
	int GIVE_OUT_MONEY = -2;
	int ENTER_THE_CODE = -3;
	int LIST_PRODUCTS = -4;
	int INVALID_INPUT = -5;
	int EXIT = -6;
	
	int getRequest();
	int getProductCode();
	int getMoneyAmount();
}
