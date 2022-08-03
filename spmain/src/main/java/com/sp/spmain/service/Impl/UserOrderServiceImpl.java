package com.sp.spmain.service.Impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.sp.spmain.common.bean.Validations;
import com.sp.spmain.common.bean.order.OderDto;
import com.sp.spmain.common.bean.order.OrderDetailsDto;
import com.sp.spmain.dto.ChecklistDto;
import com.sp.spmain.exception.ValidationException;
import com.sp.spmain.model.User;
import com.sp.spmain.model.order.OrderDetails;
import com.sp.spmain.model.order.PaymentDetails;
import com.sp.spmain.model.order.UserOrder;
import com.sp.spmain.repo.OrderDetailsRepo;
import com.sp.spmain.repo.PaymentDetailsRepo;
import com.sp.spmain.repo.UserOrderRepo;
import com.sp.spmain.service.UserOrderService;
import com.sp.spmain.temp.repo.UserRepo;
import com.sp.spmain.utility.QrCreate;

@Service
public class UserOrderServiceImpl implements UserOrderService  {

	@Autowired UserOrderRepo userOrderRepo;
	@Autowired PaymentDetailsRepo paymentDetailsRepo;
	@Autowired OrderDetailsRepo orderDetailsRepo;
	@Autowired UserRepo userRepo;
	
	@Override
	public ChecklistDto save(OderDto oderDto) throws ValidationException, NotFoundException, WriterException, IOException{

		ChecklistDto returnData= new ChecklistDto();
		UserOrder entity= new UserOrder();
		PaymentDetails payment = new PaymentDetails();
		Validations validate = new Validations();
		ArrayList<OrderDetails> orderDetailsls=new ArrayList<>();
		
		
		if(validate.validatePhoneNum(oderDto.getMobile())==false)throw new ValidationException("mobile number not valid"); 
		User user=userRepo.findByPhone(oderDto.getMobile());
		if(user==null) throw new ValidationException("No user found with this mobile number"); 
		payment.setChannel(oderDto.getPaymentDetails().getChannel());
		payment.setPaymentMode(oderDto.getPaymentDetails().getPaymentMode());
		payment.setPaymentStatus(oderDto.getPaymentDetails().getPaymentStatus());
		payment.setTransactionId(oderDto.getPaymentDetails().getTransactionId());

		entity.setPaymentDetails(payment);
		entity.setOrderStatus("PAYMENT DONE");
		entity.setTotalPrice(oderDto.getTotalPrice());
		entity.setUser(user);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy,HH:mma");
		Date date = new Date();
		
		entity.setDate(dateFormat.format(date));
		entity=userOrderRepo.save(entity);
		
		final UserOrder entity2= entity;
		
		if(oderDto.getOderItemDt()!=null && oderDto.getOderItemDt().size()!=0){
		oderDto.getOderItemDt().forEach(n->{
			OrderDetails ord=new OrderDetails();
			ord.setItemName(n.getItemName());
			ord.setItemDes(n.getItemDes());
			ord.setItemPrice(n.getItemPrice());
			ord.setMrp(n.getMrp());
			ord.setSgst(n.getSgst());
			ord.setCgst(n.getCgst());
			ord.setDprice(n.getOfferPrice());
			ord.setQuantity(n.getQuantity());
			ord.setUnitPrice(n.getUnitPrice());
			ord.setUserOrder(entity2);
			orderDetailsls.add(ord);
		});
		orderDetailsRepo.saveAll(orderDetailsls);
		returnData.setOrderDetails(orderDetailsls);
		}
	
		//*After Save
		
		returnData.setOrderId("#"+entity.getId().toString());
		returnData.setOrderQr("https://api.qrserver.com/v1/create-qr-code/?size=150x150&data="+entity.getId().toString());
		returnData.setTime(entity.getDate());
		returnData.setUserName(user.getName());
		returnData.setTotalItems(oderDto.getOderItemDt().size());
		returnData.setUserOrder(entity);
		
		return returnData;
	}

	@Override
	public ChecklistDto getorderDetailsById(OrderDetailsDto orderDetailsDto) throws ValidationException {
		// TODO Auto-generated method stub
		return null;
	}


}
