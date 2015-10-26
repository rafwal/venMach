package pl.agh.edu.vending.components;


import pl.agh.edu.vending.interfaces.*;

public class Display implements UserOutput{

	public final static int MENU = 1;
	public final static int ASK_FOR_CODE = 2;	
	public final static int ASK_FOR_MONEY = 3;
	
	public final static int THANK_YOU_MESSAGE = 4;
	public final static int IN_PROGRESS_MESSAGE = 5;
	public final static int WRONG_CODE_ERROR = 6;
	public final static int WRONG_CHOICE_ERROR = 7;
	public final static int WRONG_MONEY_AMOUNT_ERROR = 8;


	@Override
	public void showMoneyAmountInCache(int moneyAmount) {
		System.out.println();
		System.out.println();
		System.out.println("Money in cache: " + moneyAmount);
	}
	
	public void listProducts(String list){
		System.out.println();
		System.out.println("LIST OF AVAILABLE PRODUCTS");
		System.out.println(list);
	}
	
	public void giveOutChangeMessage(int change){
		System.out.println();
		System.out.println("Your change: " + change);
	}
	
	public void giveOutAllMoneyMessage(int cache){
		System.out.println();
		System.out.println("Money from cache: " + cache);
	}
	
	@Override
	public void showInformation(int type) {
		System.out.println();
		if (type == 1)
			this.showMenu();
		else if (type == 2)
			this.showAskForCodeMessage();
		else if (type == 3)
			this.showAskForMoneyAmount();
		else if (type == 4)
			this.showThankYouMessage();
		else if (type == 5)
			this.showInProgressMessage();
		else if (type == 6)
			this.showWrongCodeError();
		else if (type == 7)
			this.showWrongOptionError();
		else if (type == 8)
			this.showWrongMoneyAmount();			
	}
	
	private void showMenu(){
		System.out.println("MAIN MENU");
		System.out.println("Toss in money - press 0");
		System.out.println("Get the money back - press 1");
		System.out.println("Enter the product's code - press 2");
		System.out.println("Get products' list - press 3");
		System.out.print("EXIT - press 4:	");
	}
	
	private void showAskForCodeMessage(){
		System.out.print("Type products code: ");
	}
	
	private void showAskForMoneyAmount(){
		System.out.print("Money amount: ");
	}
	
	private void showThankYouMessage(){
		System.out.println("Thank you! Hope to see you again!");
		sleep();
	}
	
	private void showWrongCodeError(){
		System.out.println("Wrong code! Try again!");
		sleep();
	}
	
	private void showWrongOptionError(){
		System.out.println("There is no such option! Try again!");
		sleep();
	}
	
	private void showWrongMoneyAmount(){
		System.out.println("Wrong amount of money! Try again!");
		sleep();
	}
	
	private void showInProgressMessage(){
		System.out.println("In progres... Please wait");
		sleep();
		sleep();
	}
	
	
	
	private void sleep(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Problem with sleep, don't bother!");
		}
	}
}
