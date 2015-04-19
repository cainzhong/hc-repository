package com.online.shopping.orange.repository.impl;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.online.shopping.orange.domain.UserAccount;
import com.online.shopping.orange.repository.OrangeRepository;
import com.online.shopping.orange.util.HibernateUtil;

/**
 * @author Cain
 *
 */
@Repository
public class OrangeRepositoryImpl implements OrangeRepository{
	
	public UserAccount findUserAccountByUserName(String username) {
		Session userAccountSession = HibernateUtil.getSessionFactory().openSession();
		Transaction userAccountTransaction = userAccountSession.beginTransaction();

		Query query= userAccountSession.createQuery("from UserAccount where username= ?");
		query.setParameter(0, username);
		UserAccount userAccount=(UserAccount) query.uniqueResult();
		
		userAccountTransaction.commit();
		userAccountSession.close();

		HibernateUtil.shutdown();

		return userAccount;
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
