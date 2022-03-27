package com.sp.spmain.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor
public class Shop implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(length = 100)
	private String shopName;
	
	@Column(length = 100)
	private String shopCode;
	
	@Column(length = 200)
	private String geolocation;
	
	@Column(length = 500)
	private String address;
	
	@Column(length = 100)
	private String city;
	
	@Column(length = 10)
	private Integer pincode;
	
	@Column(length = 100)
	private String country;
	
	@Column(length = 100)
	private String lastupdated;
	
	@Column
	private Boolean status;
	
	@OneToMany(mappedBy = "shop", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Product> prodcut;

}
