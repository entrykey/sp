package com.sp.spmain.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;
import com.sp.spmain.dto.OderOutDto;
import com.sp.spmain.exception.ServiceException;
import com.sp.spmain.model.Product;
import com.sp.spmain.repo.ProductRepo;
import com.sp.spmain.service.Impl.ProductServiceImpl;



@Controller
@RequestMapping("sporder")
public class BillGenerateController {

	@Autowired
    private ServletContext servletContext;
	
	@Autowired ProductRepo productRepo;
	
	@GetMapping("/billgenn")
    public void genPdf(HttpServletResponse resonse) throws DocumentException, IOException {

    	 	String html = this.parseThymeleafTemplate("test Order ID");
    	    generatePdfFromHtml(html);
    	     
            String outputFolder = System.getProperty("user.home") + File.separator + "thymeleaf.pdf";
            File file = new File(outputFolder);

            // Content-Type
            // application/pdf
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
   
	@PostMapping("/billgen")
    public void genBillPdfOut(@RequestBody OderOutDto oderOutDto,HttpServletResponse resonse) throws DocumentException, IOException,ServiceException {
    	 	String html = this.parseThymeleafTemplate(oderOutDto.getOrderId().toString());
    	    System.out.println(html);
    	    generatePdfFromHtml(html);
    	     
            String outputFolder = System.getProperty("user.home") + File.separator + "thymeleaf.pdf";
            File file = new File(outputFolder);

            // Content-Type
            // application/pdf
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
	
	private String parseThymeleafTemplate(String str) {
	    ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
	    templateResolver.setSuffix(".html");
	    templateResolver.setTemplateMode(TemplateMode.HTML);

	    TemplateEngine templateEngine = new TemplateEngine();
	    templateEngine.setTemplateResolver(templateResolver);
	    Context context = new Context();
	    context.setVariable("orderId", str);
	    return templateEngine.process("templates/thymeleaf_template", context);
	}
	
	public void generatePdfFromHtml(String html) throws DocumentException, IOException {
	    String outputFolder = System.getProperty("user.home") + File.separator + "thymeleaf.pdf";
	    System.out.println(outputFolder);
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
			System.out.println(Product.toString());
            resonse.setContentType("application/png");
            resonse.setHeader(HttpHeaders.CONTENT_DISPOSITION, "body;filename=pimage.png");
            resonse.setContentLength(Product.getImage().length);
            BufferedOutputStream outStream = new BufferedOutputStream(resonse.getOutputStream());
            outStream.write(Product.getImage());
            outStream.flush();
        }
}
