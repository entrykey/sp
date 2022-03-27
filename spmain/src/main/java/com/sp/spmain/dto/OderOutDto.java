package com.sp.spmain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data @RequiredArgsConstructor @AllArgsConstructor
public class OderOutDto {
	public String orderId;
	public String orderStatus;
}
