package com.payments.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payments.entity.Payment;
import com.payments.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository payrepo;
	
	public Payment doPayment(Payment payment)
	{
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		return payrepo.save(payment);
	}
	public String paymentProcessing()
	{
		return new Random().nextBoolean()?"Success":"Failure";
	}

}
