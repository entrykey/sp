package com.sp.spmain.service;

import com.sp.spmain.dto.OderOutDto;
import com.sp.spmain.exception.ValidationException;

public interface BillGenService {

	String setTemplteBillHTML(OderOutDto oderOutDto)throws ValidationException;

}
