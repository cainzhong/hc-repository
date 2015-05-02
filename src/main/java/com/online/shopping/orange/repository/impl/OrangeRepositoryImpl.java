package com.online.shopping.orange.repository.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.online.shopping.orange.domain.OrderedItem;
import com.online.shopping.orange.domain.Product;
import com.online.shopping.orange.domain.UserAccount;
import com.online.shopping.orange.repository.OrangeRepository;
import com.online.shopping.orange.util.HibernateUtil;

/**
 * @author Cain
 *
 */
@Repository
public class OrangeRepositoryImpl implements OrangeRepository {

	private Session session;
	private Transaction transaction;

	public UserAccount findUserAccountByUserName(String username) {
		Query query = this.session.createQuery("from UserAccount as ua where ua.username= ?");
		query.setParameter(0, username);
		UserAccount userAccount = (UserAccount) query.uniqueResult();

		return userAccount;
	}

	public boolean orderItemToShoppingCart(UserAccount userAccount, Product product,long orderedQuantity) {
		try {
			OrderedItem orderedItem=new OrderedItem();
			orderedItem.setOrderdQuantity(orderedQuantity);
			orderedItem.setProduct(product);
			orderedItem.setStatus(0);
			orderedItem.setUser_Account(userAccount);
			orderedItem.setShoppingCartDate(new Timestamp(System.currentTimeMillis()));

			this.session.save(orderedItem);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<OrderedItem> getOrderedItemInShoppingCartForUser(long user_account_id) {
		Query query = this.session.createQuery("from OrderedItem where user_account_id= :user_account_id and status=0");
		query.setParameter("user_account_id", user_account_id);
		List<OrderedItem> orderedItemList = query.list();

		return orderedItemList;
	}

	public boolean deleteOrderedItemInShoppingCart(long user_account_id, int productId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean fillReceiptInfo(String recipient, String address,
			String modeOfPayment) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Open a session and begin a transaction.
	 */
	public void openSessionAndTransaction() {
		this.session = HibernateUtil.getSessionFactory().openSession();
		this.transaction = this.session.beginTransaction();
	}

	/**
	 * Close a session and commit a transaction.
	 */
	public void closeSessionAndTranstion() {
		this.transaction.commit();
		this.session.close();

		HibernateUtil.shutdown();
	}

}
