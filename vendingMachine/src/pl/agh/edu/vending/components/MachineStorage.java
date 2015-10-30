package pl.agh.edu.vending.components;


import pl.agh.edu.vending.interfaces.*;

public class MachineStorage implements Storage{

	public static final int PRODUCTS_QUANTITY = 15;
	Product [] productArray = new Product[PRODUCTS_QUANTITY];
	
	public MachineStorage(){
		initializeProducts();
	}
	
	private void initializeProducts(){
		
		productArray[0] = new Product("Black Coffee", 300, 5);
		productArray[1] = new Product("White Coffee", 300, 5);
		productArray[2] = new Product("Hot Water", 100, 5);
		productArray[3] = new Product("Tea with lemon", 300, 5);
		productArray[4] = new Product("Chocolate", 300, 5);
	}
	

	@Override
	public boolean isAvailable(int key) {
		if (key<0 || key>=productArray.length || productArray[key]==null || productArray[key].getQuantity() <= 0)
			return false;
		return true;
		
	}

	@Override
	public void giveOutProduct(int key) {
		productArray[key].setQuantity(productArray[key].getQuantity()-1);
	}

	@Override
	public int getProductPrice(int key) {
		return productArray[key].getPrice();
	}

	@Override
	public String listOfAllProductsAndQuantity() {
		StringBuilder out = new StringBuilder(); 
		for (int i=0; i<productArray.length; i++){
			if (productArray[i]!= null){
				out.append("CODE " + i + "; " +
					productArray[i].getName() +
					"; Price: " + productArray[i].getPrice() +
					"; Quantity: " + productArray[i].getQuantity() + "\n");
			}
			else
				out.append("CODE " + i + "; ??\n");
		}
		
		return out.toString();
	}

	@Override
	public String getProductName(int key) {
		return productArray[key].getName();
	}

}
