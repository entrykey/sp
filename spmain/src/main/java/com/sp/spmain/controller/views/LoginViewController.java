package com.sp.spmain.controller.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginViewController {
	
	@GetMapping("/")
	public String LoginPage(){
		return "login/login";
	}

	
	
}
