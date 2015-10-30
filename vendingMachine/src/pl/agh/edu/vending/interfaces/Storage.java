package pl.agh.edu.vending.interfaces;

public interface Storage {
	boolean isAvailable(int key);
	void giveOutProduct(int key);
	int getProductPrice(int key);
	String getProductName(int key);
	String listOfAllProductsAndQuantity();
}
