package com.online.shopping.orange.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Cain
 *
 */
@Entity
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "ORDERED_ITEM")
public class OrderedItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	@Setter
	@Column(name = "ID", nullable = false)
	private long id;

	@Getter
	@Setter
	@Column(name="ORDERED_QUANTITY")
	private long orderdQuantity;

	/**
	 * '0' indicates that the products in the shopping cart.
	 * '1' indicates that the products have been bought but the trade is in progress.
	 * '2' indicates that the products have been bought and trade has completed.
	 * '3' indicates that the user delete the product in the shopping cart.
	 */
	@Getter
	@Setter
	@Column(name="STATUS")
	private int status;

	@Getter
	@Setter
	@Column(name="SHOPPING_CART_DATE")
	private Timestamp shoppingCartDate;

	@Getter
	@Setter
	@Column(name="ORDERED_DATE")
	private Timestamp orderedDate;

	@Getter
	@Setter
	@Column(name="RECEIPT_DATE")
	private Timestamp receiptDate;

	@Getter
	@Setter
//	@Column(name="PRODUCT_ID")
	@ManyToOne(fetch=FetchType.LAZY)
	private Product product;

	@Getter
	@Setter
	@ManyToOne(fetch=FetchType.LAZY)
	private UserAccount user_Account;
}
