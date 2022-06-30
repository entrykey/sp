package com.sp.spmain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.Data;


@Entity @Data
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(length = 20)
	private String barcode;
	
	@Column(length = 100)
	private String name;
	
	@Column
	private Double mrp;
	
	@Column
	private Double cgst;
	
	@Column
	private Double sgst;
	
	@Column
	private Double offerPrice;
	
	@Column
	private Double percentage;
	
	@Lob
    @Column(name = "image", columnDefinition="BLOB")
    private byte[] image;
	
	@Transient
	private String unitInfo;
	
	@Transient
	private String imageUrl;
	
	@Column
	private Boolean status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shopId")
	private Shop shop;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "unitId")
	private ProductUnit productUnit;

}
