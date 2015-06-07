package com.haicai.portlet.repository.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.haicai.domain.Award;
import com.haicai.domain.Contact;
import com.haicai.domain.JobAsked;
import com.haicai.domain.PersonalHistory;
import com.haicai.domain.User;
import com.haicai.domain.UserRole;
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

	@Override
	@Transactional
	public boolean createUser(User user) {
		try {
			this.sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public boolean updateUser(User user) {
		try {
			this.sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
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

	@Override
	@Transactional
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

	@Override
	@Transactional
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

	@Override
	@Transactional
	public boolean updatePersonalHistory(PersonalHistory personalHistory) {
		try {
			this.sessionFactory.getCurrentSession().update(personalHistory);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public boolean createAward(User user, Award award) {
		try {
			award.setUser(user);
			this.sessionFactory.getCurrentSession().save(award);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public boolean updateAward(Award award) {
		try {
			this.sessionFactory.getCurrentSession().update(award);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public User getUserByUserName(String username) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from User as u where u.username= ?");
		query.setParameter(0, username);
		User user = (User) query.uniqueResult();
		return user;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public User getUserByUserId(int userId) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from User as u where u.id= :userId");
		query.setParameter("userId", userId);
		User user = (User) query.uniqueResult();
		return user;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public List<UserRole> getUserRolesByUser(User user){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from UserRole as ur where ur.user= :user");
		query.setParameter("user", user);
		List<UserRole> userRoles = query.list();
		return userRoles;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
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

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
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

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public List<PersonalHistory> getPersonalHistories(User user) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from PersonalHistory as ph where ph.user= :user");
		query.setParameter("user", user);
		List<PersonalHistory> personalHistoryList = query.list();
		return personalHistoryList;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public PersonalHistory getPersonalHistory(int personalHistoryId){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from PersonalHistory as ph where ph.id= :personalHistoryId");
		query.setParameter("personalHistoryId", personalHistoryId);
		PersonalHistory personalHistory = (PersonalHistory) query.uniqueResult();
		return personalHistory;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public List<Award> getAwards(User user) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Award as a where a.user= :user");
		query.setParameter("user", user);
		List<Award> awardsList = query.list();
		return awardsList;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Award getAward(int awardId) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Award as a where a.id= :awardId");
		query.setParameter("awardId", awardId);
		Award award=(Award) query.uniqueResult();
		return award;
	}

	@Override
	public boolean createJobAsked(User user, JobAsked jobAsked) {
		try {
			jobAsked.setUser(user);
			this.sessionFactory.getCurrentSession().save(jobAsked);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	/* (non-Javadoc)
	 * @see com.haicai.portlet.repository.PortletRepository#getJobAsked(com.haicai.domain.User)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public List<JobAsked> getJobAskeds(User user) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from JobAsked as ja where ja.user= :user");
		query.setParameter("user", user);
		List<JobAsked> jobAskedList = query.list();
		return jobAskedList;
	}

}
