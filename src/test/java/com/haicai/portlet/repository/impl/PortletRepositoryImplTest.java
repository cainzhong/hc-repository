package com.haicai.portlet.repository.impl;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.haicai.domain.User;

/**
 * @author Cain
 *
 */
public class PortletRepositoryImplTest {

	private static PortletRepositoryImpl portletRepositoryImpl;

	@BeforeClass
	public static void start(){
		PortletRepositoryImplTest.portletRepositoryImpl = new PortletRepositoryImpl();
		PortletRepositoryImplTest.portletRepositoryImpl.openSessionAndTransaction();
	}

	@AfterClass
	public static void end(){
		PortletRepositoryImplTest.portletRepositoryImpl.closeSessionAndTranstion();
	}

	@Test
	public void testFindUserAccountByUserName() {
		String username = "APPLE";

		User userAccount = PortletRepositoryImplTest.portletRepositoryImpl.getUserByUserName(username);

		Assert.assertEquals("APPLE", userAccount.getPassword());
	}

}
