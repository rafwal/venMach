package pl.agh.edu.vending.components;

import java.util.Scanner;

import pl.agh.edu.vending.interfaces.*;

public class UserInputPanel implements UserInput{
	
	Scanner userInput = new Scanner(System.in);
	
	
	@Override
	public  int getRequest(){
		String choice = getChoice();
		int request = interprateChoice(choice);
		return request;
	}
	
	
	private String getChoice(){
		String choice = userInput.nextLine();
		return choice;
		
	}
	
	private int interprateChoice(String choice){
		if (choice.equals("0"))
			return TOSS_IN_MONEY;
		else if (choice.equals("1"))
			return GIVE_OUT_MONEY;	
		else if (choice.equals("2"))
			return ENTER_THE_CODE;
		else if (choice.equals("3"))
		    return LIST_PRODUCTS;
		else if (choice.equals("4"))
			return EXIT;
		else
			return INVALID_INPUT;
	}

	
	@Override
	public int getProductCode() {
		int code = getCodeAndProcess();
		userInput.nextLine();
		return code;
	}
	
	
	private int getUserCode() throws Exception{
		int code = userInput.nextInt();
		return code;
	}
	
	private boolean isCodeValidate(int code){
		return (code>=0 && code <=MachineStorage.PRODUCTS_QUANTITY);
	}
	
	private int getCodeAndProcess(){
		try{
			int code = getUserCode();
			
			if (isCodeValidate(code))
				return code;
			else
				return INVALID_INPUT;
			
		}catch(Exception e){
			return INVALID_INPUT;
		}
	}

	
	@Override
	public int getMoneyAmount(){
		int moneyAmount = getMoneyAmountAndProcess();
		userInput.nextLine();
		return moneyAmount;
	}
	
	private int getMoneyAmountAndProcess(){
		try{
			int money = getUserMoney();
			
			if (isMoneyValidate(money))
				return money;
			else
				return INVALID_INPUT;
			
		}catch(Exception e){
			return INVALID_INPUT;
		}
	}
	
	private int getUserMoney() throws Exception{
		int moneyAmount =  userInput.nextInt();
		return moneyAmount;
	}
	
	private boolean isMoneyValidate(int money){
		return money>0;
	}
	
}
