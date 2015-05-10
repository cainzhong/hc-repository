package com.haicai.portlet.repository;

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


}
