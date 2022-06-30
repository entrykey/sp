package com.sp.spmain.controller.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardViewController {

	 @GetMapping("/home") 
	 public String container(){ return "body/container"; }
	 
	 @GetMapping("/dash") 
	 public String dashboard(){ return "body/dashboard"; }
	 
	 @GetMapping("/shopList")
	 public String shopList(){ return "shop/list"; }
	 
	 @GetMapping("/shopAdd")
	 public String shopAdd(){ return "shop/add"; }
	 
	 @GetMapping("/productAdd")
	 public String productAdd(){ return "product/add"; }
	 
	 @GetMapping("/productList")
	 public String productList(){ return "product/list"; }
	 
}
