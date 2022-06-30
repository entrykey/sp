package com.sp.spmain.utility;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.EncodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QrCreate {
	public static Boolean genQR(String data) throws WriterException, IOException,NotFoundException{
		
		 // The path where the image will get saved
		String path = "/var/app/current/"+data+".png";

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
		return true;
	}
}
