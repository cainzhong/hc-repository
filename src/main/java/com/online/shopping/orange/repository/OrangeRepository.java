package com.online.shopping.orange.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.online.shopping.orange.domain.UserAccount;
import com.online.shopping.orange.util.HibernateUtil;

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
	List<UserAccount> findUserAccountByUserName(String username);
	
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
