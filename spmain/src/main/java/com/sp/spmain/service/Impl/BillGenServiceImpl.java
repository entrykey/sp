package com.sp.spmain.service.Impl;

import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import com.sp.spmain.dto.OderOutDto;
import com.sp.spmain.exception.ValidationException;
import com.sp.spmain.service.BillGenService;

@Service
public class BillGenServiceImpl implements BillGenService {

	@Override
	public String setTemplteBillHTML(OderOutDto oderOutDto) throws ValidationException {
		
	    ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
	    templateResolver.setSuffix(".html");
	    templateResolver.setTemplateMode(TemplateMode.HTML);
 
	    TemplateEngine templateEngine = new TemplateEngine();
	    templateEngine.setTemplateResolver(templateResolver);
	    Context context = new Context();
	    context.setVariable("orderId", oderOutDto.orderId.toString());
	    return templateEngine.process("templates/thymeleaf_template", context);
	}

}
