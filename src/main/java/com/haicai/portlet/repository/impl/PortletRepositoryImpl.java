package com.haicai.portlet.repository.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.haicai.domain.User;
import com.haicai.hibernate.util.HibernateUtil;
import com.haicai.portlet.repository.PortletRepository;

/**
 * @author Cain
 *
 */
@Repository
public class PortletRepositoryImpl implements PortletRepository {

	private Session session;
	private Transaction transaction;

	public User getUserByUserName(String username) {
		Query query = this.session.createQuery("from User as u where u.username= ?");
		query.setParameter(0, username);
		User user = (User) query.uniqueResult();
		return user;
	}

	public User getUserByUserId(int userId) {
		Query query = this.session.createQuery("from User as u where u.id= :userId");
		query.setParameter("id", userId);
		User user = (User) query.uniqueResult();
		return user;
	}

	public User getAllUsers() {
		Query query = this.session.createQuery("from User");
		User user = (User) query.uniqueResult();
		return user;
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
