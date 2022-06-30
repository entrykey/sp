package com.sp.spmain.model.order;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sp.spmain.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	public Double totalPrice;
	private String orderStatus;
	private String date;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "paymentId")
	private PaymentDetails paymentDetails;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;

}
