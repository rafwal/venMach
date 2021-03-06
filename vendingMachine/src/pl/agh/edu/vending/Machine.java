package pl.agh.edu.vending;

import pl.agh.edu.vending.components.*;

public class Machine {
	
	MachineStorage storage = new MachineStorage();
	MachineCashier cashier = new MachineCashier();
	Display display = new Display();
	UserInputPanel inputPanel = new UserInputPanel();
	
	boolean inRun = false;
	
	
	public void run(){
		inRun = true;
		while(inRun){
			showMoneyInCacheAndMenu();			
			int request = inputPanel.getRequestAsClient();			
			processRequestAndTakeAction(request);
		}
	}
	
	
	
	private void showMoneyInCacheAndMenu(){
		display.showInformation("");
		display.showInformation("Money in cache: " + cashier.getMoneyAmountInCache());			
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
				getProductCodeFromClientAndProcess();
				break;
			}
			case UserInputPanel.LIST_PRODUCTS:{
				display.showInformation(storage.listOfAllProductsAndQuantity());
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
		else{
			tryToTossInMoneyAndShowInfo(moneyAmount);
		}
	}
	
	private void tryToTossInMoneyAndShowInfo(int moneyAmount){
		int moneySum = cashier.getMoneyAmountInCache() + moneyAmount;
		if (moneySum <= MachineCashier.CACHE_CAPACITY)
			cashier.addMoneyToCache(moneyAmount);
		else
			display.showInformation("You can toss in max 10zl (1000gr)");
	}
	
	private void getProductCodeFromClientAndProcess(){
		int code = inputPanel.getProductCode();
		
		if (code == UserInputPanel.INVALID_INPUT)
			display.showInformation("Wrong code! Try again!");
		else{
			tryToBuyProductAndDisplayInfo(code);
		}
	}
	
	private void tryToBuyProductAndDisplayInfo(int code){
		if (!storage.isAvailable(code)){
			display.showInformation("Product is unavailable or does not exist!");
			return;
		}
		
		int productPrice = storage.getProductPrice(code);
		if (!isEnoughMoneyInCache(productPrice)){
			display.showInformation("You didn't tossed in enough money");
			return;
		}
		
		
		cashier.passMoneyToDeposit(productPrice);
		storage.giveOutProduct(code);
		
		int change=0;
		if (cashier.getMoneyAmountInCache()>0){
			change = cashier.giveOutMoneyInCache();
		}
		display.showInformation("You bought " + 
								storage.getProductName(code)
								+ "\nYour change: " + change);
	}
	
	private boolean isEnoughMoneyInCache(int moneyAmount){
		return moneyAmount<=cashier.getMoneyAmountInCache();
	}
	
	private void sendRequestToCloseSystem(){
		inRun = false;
	}
	
}
