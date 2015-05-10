package com.haicai.portlet.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.haicai.domain.Awards;
import com.haicai.domain.Contact;
import com.haicai.domain.PersonalHistory;
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
		query.setParameter("userId", userId);
		User user = (User) query.uniqueResult();
		return user;
	}

	public List<Contact> getContactInfoForUser(User user) {
		Query query = this.session.createQuery("from Contact as c where c.user= :user");
		query.setParameter("user", user);
		List<Contact> contactList = query.list();
		return contactList;
	}

	public List<PersonalHistory> getPersonalHistoryForUser(User user) {
		Query query = this.session.createQuery("from PersonalHistory as ph where ph.user= :user");
		query.setParameter("user", user);
		List<PersonalHistory> personalHistoryList = query.list();
		return personalHistoryList;
	}

	public List<Awards> getAwardsForUser(User user) {
		Query query = this.session.createQuery("from Awards as a where a.user= :user");
		query.setParameter("user", user);
		List<Awards> awardsList = query.list();
		return awardsList;
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
