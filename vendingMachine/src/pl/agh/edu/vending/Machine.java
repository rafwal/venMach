package pl.agh.edu.vending;

import pl.agh.edu.vending.components.*;

public class Machine {
	MachineStorage storage = new MachineStorage();
	MachineCashier cashier = new MachineCashier();
	Display display = new Display();
	UserInputPanel inputPanel = new UserInputPanel();
	
	public void run(){
		boolean inRun = true;
		
		while(inRun){
			display.showMoneyAmountInCache(cashier.getMoneyInCache());
			display.showInformation(Display.MENU);
			
			int request = inputPanel.getRequest();
			
			if (request == UserInputPanel.TOSS_IN_MONEY){
				display.showInformation(Display.ASK_FOR_MONEY);
				
				int moneyAmount = inputPanel.getMoneyAmount();
				if (moneyAmount == UserInputPanel.INVALID_INPUT){
					display.showInformation(Display.WRONG_MONEY_AMOUNT_ERROR);
					continue;
				}
				
				cashier.addMoneyToCache(moneyAmount);
			}
				
			else if (request == UserInputPanel.GIVE_OUT_MONEY){
				int moneyAmount = cashier.giveOutMoneyInCache();
				display.giveOutAllMoneyMessage(moneyAmount);
			}
			
			else if (request == UserInputPanel.ENTER_THE_CODE){
				display.showInformation(Display.ASK_FOR_CODE);
				int code = inputPanel.getProductCode();
				
				if (code == UserInputPanel.INVALID_INPUT){
					display.showInformation(Display.WRONG_CODE_ERROR);
					continue;
				}
				
				int productPrice = storage.getProductPrice(code);
				int change = cashier.purchaseAndGiveOutChange(productPrice);
				String productName = storage.giveOutProduct(code);
				display.giveOutChangeMessage(change);				
			}
			
			else if (request == UserInputPanel.LIST_PRODUCTS){
				display.listProducts(storage.listAllProductsAndQuantity());
			}		
			
			else if (request == UserInputPanel.EXIT){
				display.showInformation(Display.THANK_YOU_MESSAGE);
				inRun = false;
			}
			else
				display.showInformation(Display.WRONG_CHOICE_ERROR);
		}
	}
	
}
