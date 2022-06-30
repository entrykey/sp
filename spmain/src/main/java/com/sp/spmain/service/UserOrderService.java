package com.sp.spmain.service;

import java.io.IOException;

import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.sp.spmain.common.bean.order.OderDto;
import com.sp.spmain.common.bean.order.OrderDetailsDto;
import com.sp.spmain.dto.ChecklistDto;
import com.sp.spmain.exception.ValidationException;

public interface UserOrderService {
	public ChecklistDto save(OderDto oderDto) throws ValidationException, NotFoundException, WriterException, IOException;
	public ChecklistDto getorderDetailsById(OrderDetailsDto orderDetailsDto)throws ValidationException;
}
