package com.customer.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CustomerBilling {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String customerBillingName;
	private String customerBillingStreet1;
	private String customerBillingStreet2;
	private String customerBillingCity;
	private String customerBillingState;
	private String customerBillingCountry;
	private String customerBillingZipcode;
	
	@OneToOne(cascade=CascadeType.ALL)
	private CustomerPayment customerPayment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerBillingName() {
		return customerBillingName;
	}

	public void setCustomerBillingName(String customerBillingName) {
		this.customerBillingName = customerBillingName;
	}

	public String getCustomerBillingStreet1() {
		return customerBillingStreet1;
	}

	public void setCustomerBillingStreet1(String customerBillingStreet1) {
		this.customerBillingStreet1 = customerBillingStreet1;
	}

	public String getCustomerBillingStreet2() {
		return customerBillingStreet2;
	}

	public void setCustomerBillingStreet2(String customerBillingStreet2) {
		this.customerBillingStreet2 = customerBillingStreet2;
	}

	public String getCustomerBillingCity() {
		return customerBillingCity;
	}

	public void setCustomerBillingCity(String customerBillingCity) {
		this.customerBillingCity = customerBillingCity;
	}

	public String getCustomerBillingState() {
		return customerBillingState;
	}

	public void setCustomerBillingState(String customerBillingState) {
		this.customerBillingState = customerBillingState;
	}

	public String getCustomerBillingCountry() {
		return customerBillingCountry;
	}

	public void setCustomerBillingCountry(String customerBillingCountry) {
		this.customerBillingCountry = customerBillingCountry;
	}

	public String getCustomerBillingZipcode() {
		return customerBillingZipcode;
	}

	public void setCustomerBillingZipcode(String customerBillingZipcode) {
		this.customerBillingZipcode = customerBillingZipcode;
	}

	public CustomerPayment getCustomerPayment() {
		return customerPayment;
	}

	public void setCustomerPayment(CustomerPayment customerPayment) {
		this.customerPayment = customerPayment;
	}
}
