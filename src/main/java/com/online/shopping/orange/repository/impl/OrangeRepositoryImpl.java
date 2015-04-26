package com.online.shopping.orange.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.online.shopping.orange.domain.OrderedItem;
import com.online.shopping.orange.domain.Product;
import com.online.shopping.orange.domain.UserAccount;
import com.online.shopping.orange.repository.OrangeRepository;
import com.online.shopping.orange.util.HibernateUtil;

/**
 * @author Cain
 *
 */
@Repository
public class OrangeRepositoryImpl implements OrangeRepository{
	
	public UserAccount findUserAccountByUserName(String username) {
		Session userAccountSession = HibernateUtil.getSessionFactory().openSession();
		Transaction userAccountTransaction = userAccountSession.beginTransaction();

		Query query= userAccountSession.createQuery("from UserAccount where username= ?");
		query.setParameter(0, username);
		UserAccount userAccount=(UserAccount) query.uniqueResult();
		
		userAccountTransaction.commit();
		userAccountSession.close();

		HibernateUtil.shutdown();

		return userAccount;
	}

	public boolean orderItemToShoppingCart(String username, int productId,
			int orderedQuantity) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<OrderedItem> getOrderedItemForUser(String username) {
	/*	Session OrderedItemSession = HibernateUtil.getSessionFactory().openSession();
		Transaction OrderedItemTransaction = OrderedItemSession.beginTransaction();

		Query query= OrderedItemSession.createQuery("from OrderedItem where username= ?");
		query.setParameter(0, username);
		 List<OrderedItem> orderedItemList=query.list();
		
		 OrderedItemTransaction.commit();
		 OrderedItemSession.close();

		HibernateUtil.shutdown();*/
		Product p1=new Product();
		Product p2=new Product();
		p1.setName("iPhone");
		p1.setPrice(6000L);
		p2.setName("Huawei");
		p2.setPrice(2000L);
		OrderedItem o1=new OrderedItem();
		OrderedItem o2=new OrderedItem();
		o1.setProduct(p1);
		o1.setOrderdQuantity(2L);
		o2.setProduct(p2);
		o2.setOrderdQuantity(1L);
		 List<OrderedItem> orderedItemList=new ArrayList<OrderedItem>();
		 orderedItemList.add(o1);
		 orderedItemList.add(o2);
		 
		return orderedItemList;
	}
	
	public boolean deleteOrderItemInShoppingCart(String username, int productId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean fillReceiptInfo(String recipient, String address,
			String modeOfPayment) {
		// TODO Auto-generated method stub
		return false;
	}

}
