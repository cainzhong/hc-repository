package com.online.shopping.orange.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "SHOPPING_LIST")
public class OrderedItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	@Setter
	@Column(name = "ID", nullable = false)
	private long id;
	
	@Getter
	@Setter
	@Column(name="ORDERD_QUANTITY")
	private long orderdQuantity;
	
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
	private Product product;
	
	@Getter
	@Setter
	@ManyToOne
	private UserAccount userAccount;
}
