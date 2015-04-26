package com.online.shopping.orange.repository;

import java.util.List;

import com.online.shopping.orange.domain.OrderedItem;
import com.online.shopping.orange.domain.UserAccount;

/**
 * @author Cain
 *
 */
public interface OrangeRepository {
	
	/** 
	 * Find a user info through user name.
	 * 
	 * @param username
	 * @return
	 */
	UserAccount findUserAccountByUserName(String username);
	
	/**
	 * Put a product into shopping cart. Note: the 'STATUS' shall be zero.
	 * 
	 * @param username
	 * @param productId
	 * @param orderedQuantity
	 * @return
	 */
	boolean orderItemToShoppingCart(String username,int productId,int orderedQuantity);
	
	/**
	 * Get all products who puts them into the shopping cart. Note: find the 'STATUS' which is zero.
	 * 
	 * @param username
	 * @return
	 */
	List<OrderedItem> getOrderedItemForUser(String username);
	
	/**
	 * The user delete the product in the shopping cart. Note: set the 'STATUS' as three.
	 * 
	 * @param username
	 * @param productId
	 * @return
	 */
	boolean deleteOrderItemInShoppingCart(String username,int productId);
	
	/**
	 * Fill the info of receipting, such as recipient, address and mode of payment.
	 * 
	 * @param recipient
	 * @param address
	 * @param modeOfPayment
	 * @return
	 */
	boolean fillReceiptInfo(String recipient,String address,String modeOfPayment);
	
	
}
