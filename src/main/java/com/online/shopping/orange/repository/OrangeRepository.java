package com.online.shopping.orange.repository;

import java.util.List;

import com.online.shopping.orange.domain.OrderedItem;
import com.online.shopping.orange.domain.Product;
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
	 * @param userAccount
	 * @param product
	 * @param orderedQuantity
	 * @return
	 */
	boolean orderItemToShoppingCart(UserAccount userAccount,Product product,long orderedQuantity);

	/**
	 * Get all products which put them into the shopping cart for someone. Note: find the 'STATUS' which is zero.
	 *
	 * @param userAccountId
	 * @return
	 */
	List<OrderedItem> getOrderedItemInShoppingCartForUser(long userAccountId);

	/**
	 * The user delete the product in the shopping cart. Note: set the 'STATUS' as three.
	 *
	 * @param user_account_id
	 * @param productId
	 * @return
	 */
	boolean deleteOrderedItemInShoppingCart(long userAccountId,int productId);

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
