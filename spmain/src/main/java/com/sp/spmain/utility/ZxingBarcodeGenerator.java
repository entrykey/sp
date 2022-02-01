package com.sp.spmain.utility;

import java.io.File;
import java.io.IOException;

import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;



public class ZxingBarcodeGenerator {

	// Function to create the QR code
    @SuppressWarnings("deprecation")
	public static void createQR(String data, String path,String charset, Map hashMap,int height, int width)
        throws WriterException, IOException
    {
 
        BitMatrix matrix = new MultiFormatWriter().encode(
            new String(data.getBytes(charset), charset),
            BarcodeFormat.QR_CODE, width, height);
        MatrixToImageWriter.writeToFile(
            matrix,
            path.substring(path.lastIndexOf('.') + 1),
            new File(path));
    }
    
 // Function to create the QR code
    @SuppressWarnings("deprecation")
	public static void ean13Code(String data, String path,String charset, Map hashMap,int height, int width)
        throws WriterException, IOException
    {
 
        BitMatrix matrix = new MultiFormatWriter().encode(
            new String(data.getBytes(charset), charset),
            BarcodeFormat.EAN_13, width, height);
        MatrixToImageWriter.writeToFile(
            matrix,
            path.substring(path.lastIndexOf('.') + 1),
            new File(path));
    }
}
