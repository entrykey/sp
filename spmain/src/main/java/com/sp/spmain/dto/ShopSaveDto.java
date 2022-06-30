package com.sp.spmain.dto;

import lombok.Data;

@Data
public class ShopSaveDto {
	private String shopName;
	private String latitude;
	private String longitude;
	private String address;
	private String city;
	private Integer pincode;
}
