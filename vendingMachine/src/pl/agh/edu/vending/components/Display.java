package pl.agh.edu.vending.components;


import pl.agh.edu.vending.interfaces.*;

public class Display implements UserOutput{

	@Override
	public void showInformation(String information) {
		System.out.println();
		System.out.println(information);
	}
	
}
