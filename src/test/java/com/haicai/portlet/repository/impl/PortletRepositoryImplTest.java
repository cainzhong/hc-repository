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
	public void testGetUserByUserName() {
		String username = "email@email.com";

		User user = PortletRepositoryImplTest.portletRepositoryImpl.getUserByUserName(username);

		Assert.assertEquals("password", user.getPassword());
	}

	@Test
	public void testGetAllUsers() {

		User user = PortletRepositoryImplTest.portletRepositoryImpl.getAllUsers();

		Assert.assertEquals("passwod", user.getPassword());
	}

}
