package pl.agh.edu.vending;

import pl.agh.edu.vending.components.*;

public class Machine {
	
	MachineStorage storage = new MachineStorage();
	MachineCashier cashier = new MachineCashier();
	Display display = new Display();
	UserInputPanel inputPanel = new UserInputPanel();
	
	boolean inRun = true;
	
	
	public void run(){		
		while(inRun){
			showMoneyInCacheAndMenu();			
			int request = inputPanel.getRequest();			
			processRequestAndTakeAction(request);
		}
	}
	
	private void showMoneyInCacheAndMenu(){
		display.showInformation("");
		display.showInformation("Money in cache: " + cashier.getMoneyInCache());			
		display.showInformation("MAIN MENU\n" + 
				"Toss in money - press 0\n" + 
				"Get the money back - press 1\n" +
				"Enter the product's code - press 2\n" + 
				"Get products' list - press 3\n" +
				"EXIT - press 4:	");
	}
	
	private void processRequestAndTakeAction(int request){
		
		switch(request){
		
			case UserInputPanel.TOSS_IN_MONEY:{
				display.showInformation("Money amount: ");
				getMoneyAmountFromClient();
				break;
			}
				
			case UserInputPanel.GIVE_OUT_MONEY:{
				int moneyAmount = cashier.giveOutMoneyInCache();
				display.showInformation("Money from cache: " + moneyAmount);
				break;
			}
			
			case UserInputPanel.ENTER_THE_CODE:{
				display.showInformation("Type products code: ");
				getProductCodeFromClient();
				break;
			}
			case UserInputPanel.LIST_PRODUCTS:{
				display.showInformation(storage.listAllProductsAndQuantity());
				break;
			}					
			case UserInputPanel.EXIT:{
				display.showInformation("Thank you! Hope to see you again!");
				sendRequestToCloseSystem();
				break;
			}			
			default:{
				display.showInformation("There is no such option! Try again!");
				break;
			}
		}
	}
	
	private void getMoneyAmountFromClient(){
		int moneyAmount = inputPanel.getMoneyAmount();					
		if (moneyAmount == UserInputPanel.INVALID_INPUT)
			display.showInformation("Wrong amount of money! Try again!");
		else
			cashier.addMoneyToCache(moneyAmount);				
	}
	
	private void getProductCodeFromClient(){
		int code = inputPanel.getProductCode();
		
		if (code == UserInputPanel.INVALID_INPUT)
			display.showInformation("Wrong code! Try again!");
		else{
			buyProductAndDisplayInfo(code);
		}
	}
	
	private void buyProductAndDisplayInfo(int code){
		int productPrice = storage.getProductPrice(code);
		int change = cashier.purchaseAndGiveOutChange(productPrice);
		String productName = storage.giveOutProduct(code);
		display.showInformation("You bought " + productName + "\nYour change: " + change);
	}
	
	private void sendRequestToCloseSystem(){
		inRun = false;
	}
}
