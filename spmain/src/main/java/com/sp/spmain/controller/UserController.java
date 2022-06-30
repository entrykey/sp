package com.sp.spmain.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.zxing.EncodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.sp.spmain.temp.service.OtpServiceImpl;
import com.sp.spmain.utility.ZxingBarcodeGenerator;


@RestController
public class UserController {
	
	 	@Autowired OtpServiceImpl otpServiceImpl;
	 
		/*
		 * @GetMapping("/") public String welcome() { return "Welcome to smart Pay...";
		 * }
		 */
	 	
	 	@RequestMapping(value = "/", method = RequestMethod.GET)
	 	public ModelAndView method() {
	 	    return new ModelAndView("redirect:" + "/home");
	 	}
	 	
		@GetMapping(value = "/otp")
		public Boolean opttest() { 
			return true;
		}
		
		
		@GetMapping(value = "/qr")
	    public String qr() throws WriterException, IOException,NotFoundException
	    {
		
		 // The data that the QR code will contain
		 String data = "123123123123";
		
		 // The path where the image will get saved
		 String path = "src/main/resources/static/qr/demo.png";
		
		 // Encoding charset
		 String charset = "UTF-8";
		
		 Map<EncodeHintType, ErrorCorrectionLevel> hashMap
		     = new HashMap<EncodeHintType,
		                   ErrorCorrectionLevel>();
		
		 hashMap.put(EncodeHintType.ERROR_CORRECTION,
		             ErrorCorrectionLevel.L);
		
		 // Create the QR code and save
		 // in the specified folder
		 // as a jpg file
		 ZxingBarcodeGenerator.createQR(data, path, charset, hashMap, 200, 200);
		 System.out.println("QR Code Generated!!! ");
		 return "";
}

}
