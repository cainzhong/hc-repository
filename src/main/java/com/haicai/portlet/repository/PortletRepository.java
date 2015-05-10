package com.haicai.portlet.repository;

import java.util.List;

import com.haicai.domain.Awards;
import com.haicai.domain.Contact;
import com.haicai.domain.PersonalHistory;
import com.haicai.domain.User;

/**
 * @author Cain
 *
 */
public interface PortletRepository {

	/**
	 * Find a user info through user name.
	 *
	 * @param username
	 * @return
	 */
	User getUserByUserName(String username);

	/**
	 *  Find a user info through user id.
	 *
	 * @param userId
	 * @return
	 */
	User getUserByUserId(int userId);

	/**
	 * Find contact info for a user.
	 *
	 * @param user
	 * @return
	 */
	List<Contact> getContactInfoForUser(User user);

	/**
	 * Find personal history for a user.
	 *
	 * @param user
	 * @return
	 */
	List<PersonalHistory> getPersonalHistoryForUser(User user);

	/**
	 * Find awards for a user.
	 *
	 * @param user
	 * @return
	 */
	List<Awards> getAwardsForUser(User user);

	/**
	 * Add a user into database.
	 *
	 * @param user
	 * @return
	 */
	boolean addUser(User user);

	/**
	 * Add contact info for a user.
	 *
	 * @param user
	 * @param contact
	 * @return
	 */
	boolean addContactForUser(User user,Contact contact);

	/**
	 * Add personal history for a user.
	 *
	 * @param user
	 * @param personalHistory
	 * @return
	 */
	boolean addPersonalHistoryForUser(User user,PersonalHistory personalHistory);

	/**
	 * Add awards for a user.
	 *
	 * @param user
	 * @param awards
	 * @return
	 */
	boolean addAwardsForUser(User user,Awards awards);
}
