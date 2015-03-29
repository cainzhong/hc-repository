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
public class OrangeRepository {
	public List<UserAccount> findUserAccountByUserName(String username) {
		Session userAccountSession = HibernateUtil.getSessionFactory().openSession();
		Transaction userAccountTransaction = userAccountSession.beginTransaction();

		List<UserAccount> userAccountlList = userAccountSession.createQuery("from UserAccount").list();

		userAccountTransaction.commit();
		userAccountSession.close();

		HibernateUtil.shutdown();

		return userAccountlList;
	}
}
