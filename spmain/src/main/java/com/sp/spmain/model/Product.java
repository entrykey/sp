package com.sp.spmain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
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
	private Long mrp;
	
	@Column
	private Long offerPrice;
	
	@Column
	private Long percentage;
	
	@Column(length = 100)
	private String image;
	
	@Column
	private Boolean status;
	
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
     @JoinColumn(name = "shopid", insertable = false, updatable = false)
	 private Shop shop;
	 
	 public Shop getShop() { return shop; }
	  
	 public void setShop(Shop shop) { this.shop = shop; }
	 

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMrp() {
		return mrp;
	}

	public void setMrp(Long mrp) {
		this.mrp = mrp;
	}

	public Long getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(Long offerPrice) {
		this.offerPrice = offerPrice;
	}

	public Long getPercentage() {
		return percentage;
	}

	public void setPercentage(Long percentage) {
		this.percentage = percentage;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	
}
