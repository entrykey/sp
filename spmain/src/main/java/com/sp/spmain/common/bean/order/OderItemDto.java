package com.sp.spmain.common.bean.order;

import lombok.Data;

@Data
public class OderItemDto {
	public String itemName;   
	public String itemDes;
	public Integer quantity;
	private Double mrp;
	private Double unitPrice;
	private Double itemPrice;
}
