package com.haicai.portlet.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haicai.domain.Award;
import com.haicai.domain.Contact;
import com.haicai.domain.PersonalHistory;
import com.haicai.domain.User;
import com.haicai.domain.type.ContactType;
import com.haicai.domain.type.Status;
import com.haicai.hibernate.util.HibernateUtil;
import com.haicai.portlet.repository.PortletRepository;

/**
 * @author Cain
 *
 */
@Repository
public class PortletRepositoryImpl implements PortletRepository,Serializable {

	private static final long serialVersionUID = 7424047476958283440L;

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session session;
	private Transaction transaction;

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

	public boolean createUser(User user) {
		try {
			this.sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateUser(User user) {
		try {
			this.sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean createContact(User user, Contact contact) {
		try {
			contact.setUser(user);
			this.sessionFactory.getCurrentSession().save(contact);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean disableContact(Contact contact){
		try {
			contact.setStatus(Status.INACTIVE);
			this.sessionFactory.getCurrentSession().update(contact);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean createPersonalHistory(User user, PersonalHistory personalHistory) {
		try {
			personalHistory.setUser(user);
			this.sessionFactory.getCurrentSession().save(personalHistory);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updatePersonalHistory(PersonalHistory personalHistory) {
		try {
			this.sessionFactory.getCurrentSession().update(personalHistory);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean createAward(User user, Award awards) {
		try {
			awards.setUser(user);
			this.sessionFactory.getCurrentSession().save(awards);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateAward(Award award) {
		try {
			this.sessionFactory.getCurrentSession().update(award);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public User getUserByUserName(String username) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from User as u where u.username= ?");
		query.setParameter(0, username);
		User user = (User) query.uniqueResult();
		return user;
	}

	public User getUserByUserId(int userId) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from User as u where u.id= :userId");
		query.setParameter("userId", userId);
		User user = (User) query.uniqueResult();
		return user;
	}

	public List<Contact> getContacts(User user, Status status) {
		StringBuffer sqlQuery = new StringBuffer();
		sqlQuery.append("from Contact as c where c.user = :user");
		if (status != null) {
			sqlQuery.append(" and c.status = :status");
		}

		Query query = this.sessionFactory.getCurrentSession().createQuery(sqlQuery.toString());
		query.setParameter("user", user);
		if (status != null) {
			query.setParameter("status", status);
		}
		List<Contact> contactList = query.list();
		return contactList;
	}

	public Contact getSpecificActiveContact(User user, ContactType contactType, String otherDdescription) {
		StringBuffer sqlQuery = new StringBuffer();
		sqlQuery.append("from Contact as c where c.user = :user and c.status =:status and c.type = :contactType");
		if (contactType.equals(ContactType.OTHER)) {
			sqlQuery.append(" and upper(c.otherDdescription) = :otherDdescription");
		}
		Query query = this.sessionFactory.getCurrentSession().createQuery(sqlQuery.toString());
		query.setParameter("user", user);
		query.setParameter("status", Status.ACTIVE);
		query.setParameter("contactType", contactType);
		if (contactType.equals(ContactType.OTHER)) {
			query.setParameter("otherDdescription", otherDdescription.toUpperCase());
		}
		return (Contact) query.uniqueResult();
	}

	public List<PersonalHistory> getPersonalHistories(User user) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from PersonalHistory as ph where ph.user= :user");
		query.setParameter("user", user);
		List<PersonalHistory> personalHistoryList = query.list();
		return personalHistoryList;
	}

	public PersonalHistory getPersonalHistory(int personalHistoryId){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from PersonalHistory as ph where ph.id= :personalHistoryId");
		query.setParameter("personalHistoryId", personalHistoryId);
		PersonalHistory personalHistory = (PersonalHistory) query.uniqueResult();
		return personalHistory;
	}

	public List<Award> getAwards(User user) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Award as a where a.user= :user");
		query.setParameter("user", user);
		List<Award> awardsList = query.list();
		return awardsList;
	}

	public Award getAward(int awardId) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Award as a where a.id= :awardId");
		query.setParameter("awardId", awardId);
		Award award=(Award) query.uniqueResult();
		return award;
	}

}
