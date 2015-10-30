package pl.agh.edu.vending.interfaces;

/**
 * This interface deliver functions to operate products in vending machine. 
 */
public interface Storage {
	
	/**
	 * This function determines whether the product is available
	 * @param key is an index of product
	 * @return true if product is available and false otherwise
	 */
	boolean isAvailable(int key);
	
	/**Function gives the product out to client
	 * @param key is an index of product
	 */
	void giveOutProduct(int key);
	
	/**
	 * Functions return product's price
	 * @param key is an index of product
	 * @return products price
	 */
	int getProductPrice(int key);
	
	/**
	 * Function returns product's name
	 * @param key is an index of product
	 * @return product's name
	 */
	String getProductName(int key);
	
	/**
	 * Returns list of available products
	 * @return list of products as String
	 */
	String listOfAllProductsAndQuantity();
}
