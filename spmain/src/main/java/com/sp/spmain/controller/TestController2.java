package com.sp.spmain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.spmain.model.order.UserOrder;
import com.sp.spmain.repo.OrderDetailsRepo;
import com.sp.spmain.repo.UserOrderRepo;


@RestController
@RequestMapping("spshop")
public class TestController2 {
	
	@Autowired UserOrderRepo userOrderRepo;
	@Autowired OrderDetailsRepo orderDetailsRepo;
			   
	
 	@GetMapping("/usertest") public UserOrder testUser() {
 		
 		UserOrder ord= new UserOrder();
 		ord=userOrderRepo.getById(36L);
 		
 		System.out.println("UserOrder:"+ord);
 		
 		System.out.println(orderDetailsRepo.findByUserOrderId(36L));
 		return ord;
 	}
 	  	
}
