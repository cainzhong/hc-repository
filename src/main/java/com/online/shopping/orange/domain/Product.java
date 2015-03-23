package com.online.shopping.orange.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
@Table(name = "PRODUCT")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	@Setter
	@Column(name = "ID", nullable = false)
	private long id;
	
	@Getter
	@Setter
	@Column(name = "NAME",unique=true,nullable=false)
	private String name;
	
	@Getter
	@Setter
	@Column(name = "PRODUCT_TYPE")
	private String productType;
	
	@Getter
	@Setter
	@Column(name = "INFO")
	private String info;
	
	@Getter
	@Setter
	@Column(name = "PRICE")
	private long price;
	
	@Getter
	@Setter
	@OneToOne
	private Stock stock;
}
