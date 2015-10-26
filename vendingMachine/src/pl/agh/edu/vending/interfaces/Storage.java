package pl.agh.edu.vending.interfaces;

public interface Storage {
	boolean isAvailable(int key);
	String giveOutProduct(int key);
	int getProductPrice(int key);
	String listAllProductsAndQuantity();
}
