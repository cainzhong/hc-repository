package com.online.shopping.orange.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.online.shopping.orange.domain.UserAccount;
import com.online.shopping.orange.repository.OrangeRepository;
import com.online.shopping.orange.util.HibernateUtil;

/**
 * @author Cain
 *
 */
public class OrangeRepositoryImpl implements OrangeRepository{
	
	public List<UserAccount> findUserAccountByUserName(String username) {
		Session userAccountSession = HibernateUtil.getSessionFactory().openSession();
		Transaction userAccountTransaction = userAccountSession.beginTransaction();

		List<UserAccount> userAccountlList = userAccountSession.createQuery("from UserAccount").list();

		userAccountTransaction.commit();
		userAccountSession.close();

		HibernateUtil.shutdown();

		return userAccountlList;
	}

	public boolean orderItemToShoppingCart(String username, int productId,
			int orderedQuantity) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteOrderItemInShoppingCart(String username, int productId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean fillReceiptInfo(String recipient, String address,
			String modeOfPayment) {
		// TODO Auto-generated method stub
		return false;
	}
}
