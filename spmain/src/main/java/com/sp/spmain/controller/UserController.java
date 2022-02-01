package com.sp.spmain.controller;


import java.io.IOException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.sp.spmain.utility.ZxingBarcodeGenerator;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

@RestController
public class UserController {

		@GetMapping("/")
	    public String welcome() {
			
			
	        return "Welcome to smart Pay...";
	    }
		
		
		@GetMapping(value = "/qr")
	    public String qr() throws WriterException, IOException,NotFoundException
	    {
		 // The data that the QR code will contain
		 String data = "123123123123";
		
		 // The path where the image will get saved
		 String path = "demo.png";
		
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
