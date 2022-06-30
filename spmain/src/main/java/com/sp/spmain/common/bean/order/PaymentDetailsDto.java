package com.sp.spmain.common.bean.order;

import lombok.Data;

@Data
public class PaymentDetailsDto {
	
	public String channel;
	public String transactionId;
	public String paymentMode;
	public String paymentStatus;

}
