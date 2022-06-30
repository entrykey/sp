package com.sp.spmain.common.bean.order;

import java.util.ArrayList;

import lombok.Data;

@Data
public class OderDto {
	public String userName;
	public String mobile;
	public Double totalPrice;
	public String time;
	public PaymentDetailsDto paymentDetails;
	public ArrayList<OderItemDto> OderItemDt;

}
