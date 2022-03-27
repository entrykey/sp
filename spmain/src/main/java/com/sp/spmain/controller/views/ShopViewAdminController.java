package com.sp.spmain.controller.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class ShopViewAdminController {
	
	 @GetMapping("/shop") 
	 public String shopList(){ return "shop/list"; }
	 @GetMapping("/shop/add") 
	 public String shopAdd(){ return "shop/add"; }
}
