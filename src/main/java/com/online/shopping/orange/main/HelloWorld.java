 /**
 *@Project: Team-Excellence-Hibernate-Repository
 *
 *@Date: 2015��1��21��
 *@Copyright: 2015 sg.nomaka.tk Inc. All rights reserved.
 */
package com.online.shopping.orange.main;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.online.shopping.orange.domain.UserAccount;
import com.online.shopping.orange.util.HibernateUtil;


/**
 * @author Cain
 *
 */
public class HelloWorld {
	public static void main(String args[]){
//		System.out.println("***********************11******************");
//		Session session=HibernateUtil.getSessionFactory().openSession();
//		Transaction tx=session.beginTransaction();
//		System.out.println("*****************************************");
		UserAccount userAccount=new UserAccount();
//		userAccount
//		userAccount.setPrimaryEmail("abc@a.com");
//		Long emailID=(Long) session.save(userAccount);
//		tx.commit();
//		session.close();
		
		Session newSession=HibernateUtil.getSessionFactory().openSession();
		Transaction newTransaction=newSession.beginTransaction();
		
		List<UserAccount> userAccountlList=newSession.createQuery("from UserAccount").list();
		
		System.out.println(userAccountlList.size()+" record(s) found:");
		
		newTransaction.commit();
		newSession.close();
		
		HibernateUtil.shutdown();
	}
}
