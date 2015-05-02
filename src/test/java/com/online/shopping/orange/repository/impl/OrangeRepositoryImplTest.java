package com.online.shopping.orange.repository.impl;

import java.util.List;

import junit.framework.Assert;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.service.spi.Startable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.online.shopping.orange.domain.OrderedItem;
import com.online.shopping.orange.domain.UserAccount;
import com.online.shopping.orange.util.HibernateUtil;

/**
 * @author Cain
 *
 */
public class OrangeRepositoryImplTest {

	private static OrangeRepositoryImpl orangeRepositoryImpl;

	@BeforeClass
	public static void start(){
		orangeRepositoryImpl = new OrangeRepositoryImpl();
		orangeRepositoryImpl.openSessionAndTransaction();
	}
	
	@AfterClass
	public static void end(){
		orangeRepositoryImpl.closeSessionAndTranstion();
	}

	@Test
	public void testFindUserAccountByUserName() {
		String username = "APPLE";

		UserAccount userAccount = orangeRepositoryImpl.findUserAccountByUserName(username);

		Assert.assertEquals("APPLE", userAccount.getPassword());
	}

	@Test
	public void testGetOrderedItemForUser() {
		long user_account_id = 1L;

		List<OrderedItem> orderedItemList = orangeRepositoryImpl.getOrderedItemInShoppingCartForUser(user_account_id);

		Assert.assertEquals(1, orderedItemList.size());
		for (OrderedItem orderedItem : orderedItemList) {
			Assert.assertEquals(2, orderedItem.getOrderdQuantity());
			Assert.assertEquals(0, orderedItem.getStatus());
			// Assert.assertEquals(1, orderedItem.getProduct().getId());
		}
	}

}
