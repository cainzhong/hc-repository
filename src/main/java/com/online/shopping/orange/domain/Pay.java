package com.online.shopping.orange.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "PAY")
public class Pay {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	@Setter
	@Column(name = "ID", nullable = false)
	private long id;
	
	@Getter
	@Setter
	@Column(name="TOTAL_PRICE")
	private String totalPrice;
	
	@Getter
	@Setter
	@Column(name="BANK_NAME")
	private String bankName;
	
	@Getter
	@Setter
	@ManyToOne
	private UserAccount userAccount;
	
	@Getter
	@Setter
	@OneToMany
	private OrderedItem orderedItem;
}
