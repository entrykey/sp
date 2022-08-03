package com.sp.spmain.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xhtmlrenderer.pdf.ITextRenderer;
import com.lowagie.text.DocumentException;
import com.sp.spmain.dto.OderOutDto;
import com.sp.spmain.exception.ServiceException;
import com.sp.spmain.exception.ValidationException;
import com.sp.spmain.model.Product;
import com.sp.spmain.repo.ProductRepo;
import com.sp.spmain.service.BillGenService;
import com.sp.spmain.service.Impl.BillGenServiceImpl;
import com.sp.spmain.service.Impl.ProductServiceImpl;



@Controller
@RequestMapping("sporder")
public class BillGenerateController {

	@Autowired private BillGenServiceImpl billGenServiceImpl;
	
	@Autowired ProductRepo productRepo;
	
	
	@PostMapping("/billgen")
    public void genBillPdfOut(@RequestBody OderOutDto oderOutDto,HttpServletResponse resonse) throws DocumentException, IOException,ServiceException, ValidationException {
			String html= billGenServiceImpl.setTemplteBillHTML(oderOutDto);
    	    generatePdfFromHtml(html);
            String outputFolder = System.getProperty("user.home") + File.separator + "thymeleaf.pdf";
            File file = new File(outputFolder);
            resonse.setContentType("application/pdf");

            // Content-Disposition
            resonse.setHeader(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=" + file.getName());

            // Content-Length
            resonse.setContentLength((int) file.length());

            BufferedInputStream inStream = new BufferedInputStream(new FileInputStream(file));
            BufferedOutputStream outStream = new BufferedOutputStream(resonse.getOutputStream());

            byte[] buffer = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
            outStream.flush();
            inStream.close();
        }
	
	public void generatePdfFromHtml(String html) throws DocumentException, IOException {
	    String outputFolder = System.getProperty("user.home") + File.separator + "thymeleaf.pdf";
	    OutputStream outputStream = new FileOutputStream(outputFolder);
	    ITextRenderer renderer = new ITextRenderer();
	    renderer.setDocumentFromString(html);
	    renderer.layout();
	    renderer.createPDF(outputStream);
	    outputStream.close();
	}
	 
	@GetMapping("/pimage/{pid}")
    public void ProductImageOut(@PathVariable("pid") Integer pid,HttpServletResponse resonse) throws DocumentException, IOException,ServiceException {
			Product Product = productRepo.findById(pid);
			if(Product.getImage()!=null){
				System.out.println(Product.toString());
	            resonse.setContentType("application/png");
	            resonse.setHeader(HttpHeaders.CONTENT_DISPOSITION, "body;filename=pimage.png");
	            resonse.setContentLength(Product.getImage().length);
	            BufferedOutputStream outStream = new BufferedOutputStream(resonse.getOutputStream());
	            outStream.write(Product.getImage());
	            outStream.flush();
			}
			
        }
}
