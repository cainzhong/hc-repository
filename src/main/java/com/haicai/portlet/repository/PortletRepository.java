package com.haicai.portlet.repository;

import java.util.List;

import com.haicai.domain.Awards;
import com.haicai.domain.Contact;
import com.haicai.domain.PersonalHistory;
import com.haicai.domain.User;
import com.haicai.domain.type.ContactType;
import com.haicai.domain.type.Status;

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
	 * @param status
	 * @return
	 */
	List<Contact> getContactInfoForUser(User user,Status status);

	/**
	 * Find a specific and active contact info for a user.
	 *
	 * @param user
	 * @param contactType
	 * @param otherDdescription
	 * @return
	 */
	Contact getSpecificActiveContactInfoForUser(User user,ContactType contactType, String otherDdescription);

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
	 * Create a user into database.
	 *
	 * @param user
	 * @return
	 */
	boolean createUser(User user);

	/**
	 * Create contact info for a user.
	 *
	 * @param user
	 * @param contact
	 * @return
	 */
	boolean createContactForUser(User user,Contact contact);

	/**
	 * Update contact info for a user.
	 *
	 * @param user
	 * @param contact
	 * @return
	 */
	boolean updateContactForUser(User user,Contact contact);

	/**
	 * Create personal history for a user.
	 *
	 * @param user
	 * @param personalHistory
	 * @return
	 */
	boolean createPersonalHistoryForUser(User user,PersonalHistory personalHistory);

	/**
	 * Create awards for a user.
	 *
	 * @param user
	 * @param awards
	 * @return
	 */
	boolean createAwardsForUser(User user,Awards awards);
}
