package com.sp.spmain.dto;

import java.util.ArrayList;

import com.sp.spmain.model.order.OrderDetails;
import com.sp.spmain.model.order.UserOrder;

import lombok.Data;

@Data
public class ChecklistDto {

public String OrderId;
public String userName;
public String orderQr;
public String time;
public Integer totalItems;
public UserOrder userOrder;
public ArrayList<OrderDetails> orderDetails;
}
