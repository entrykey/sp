package com.sp.spmain.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSaveDto {
	private Integer shopId;
	private Integer unitId;
	private String productName;
	private String barcode;
	private Double mrp;
	private Double cgst;
	private Double sgst;
	private Double offerPrice;
	private MultipartFile productImage;
}
