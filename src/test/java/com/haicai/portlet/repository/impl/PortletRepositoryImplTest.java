package com.haicai.portlet.repository.impl;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.haicai.domain.Awards;
import com.haicai.domain.Contact;
import com.haicai.domain.PersonalHistory;
import com.haicai.domain.User;
import com.haicai.domain.type.AwardsType;
import com.haicai.domain.type.ContactType;
import com.haicai.domain.type.IdNumberType;
import com.haicai.domain.type.Sex;
import com.haicai.domain.type.UniversityDegree;

/**
 * @author Cain
 *
 */
public class PortletRepositoryImplTest {

	private static PortletRepositoryImpl portletRepositoryImpl;
	private final int userId=1;
	private User user;
	private Contact emailContact;
	private Contact telephoneContact;
	private Contact otherContact;
	private PersonalHistory personalHistory;
	private Awards awards;
	private List<Contact> contactList;
	private List<PersonalHistory> personalHistoryList;
	private List<Awards> awardsList;

	@Before
	public void setUp(){
		this.user=new User();
		this.user.setId(1);
		this.user.setUsername("email@email.com");
		this.user.setRealName("Real Name");
		this.user.setEnglishName("Cain");
		this.user.setPassword("password");
		this.user.setSex(Sex.MALE);
		this.user.setIdNumber("310229123456789");
		this.user.setIdNumberType(IdNumberType.IDENTITYCARD);
		this.user.setCurrentCountry("USA");
		this.user.setCurrentCity("San Diego");

		this.emailContact=new Contact();
		this.telephoneContact=new Contact();
		this.otherContact=new Contact();
		this.contactList=new ArrayList<Contact>();

		this.emailContact.setId(1);
		this.emailContact.setInfo("email@email.com");
		this.emailContact.setType(ContactType.EMAIL);
		this.emailContact.setOtherDdescription("");
		this.emailContact.setUser(this.user);

		this.telephoneContact.setId(2);
		this.telephoneContact.setInfo("911");
		this.telephoneContact.setType(ContactType.TELEPHONE);
		this.telephoneContact.setOtherDdescription("");
		this.telephoneContact.setUser(this.user);

		this.otherContact.setId(3);
		this.otherContact.setInfo("123456");
		this.otherContact.setType(ContactType.OTHER);
		this.otherContact.setOtherDdescription("WebChat");
		this.otherContact.setUser(this.user);

		this.contactList.add(this.emailContact);
		this.contactList.add(this.telephoneContact);
		this.contactList.add(this.otherContact);

		this.personalHistory=new PersonalHistory();
		this.personalHistoryList=new ArrayList<PersonalHistory>();
		this.personalHistory.setId(1);
		this.personalHistory.setUniversity("San Diego State University");
		this.personalHistory.setUniversityDegree(UniversityDegree.Doctor);
		this.personalHistory.setGraduationYear("2013-01-01");
		this.personalHistory.setUser(this.user);
		this.personalHistoryList.add(this.personalHistory);

		this.awards=new Awards();
		this.awardsList=new ArrayList<Awards>();
		this.awards.setId(1);
		this.awards.setType(AwardsType.HonoraryTitle);
		this.awards.setDescription("Captain");
		this.awards.setReferrer("Bill");
		this.awards.setOther("");
		this.awards.setUser(this.user);
		this.awardsList.add(this.awards);
	}

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
		Assert.assertEquals(this.user,user);
	}

	@Test
	public void testGetUserByUserId() {
		User user = PortletRepositoryImplTest.portletRepositoryImpl.getUserByUserId(this.userId);
		Assert.assertEquals(this.user,user);
	}

	@Test
	public void testGetContactInfoForUser(){
		List<Contact> contactList=PortletRepositoryImplTest.portletRepositoryImpl.getContactInfoForUser(this.user);
		Assert.assertEquals(this.contactList,contactList);
	}

	@Test
	public void testGetPersonalHistoryForUser(){
		List<PersonalHistory> personalHistoryList=PortletRepositoryImplTest.portletRepositoryImpl.getPersonalHistoryForUser(this.user);
		Assert.assertEquals(this.personalHistoryList,personalHistoryList);
	}

	@Test
	public void testGetAwardsForUser(){
		List<Awards> awardsList=PortletRepositoryImplTest.portletRepositoryImpl.getAwardsForUser(this.user);
		Assert.assertEquals(this.awardsList,awardsList);
	}

}
