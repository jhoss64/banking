package com.ads2018II.banking.application.dto.accounts;

import java.math.BigDecimal;

import com.ads2018II.banking.application.dto.costumers.CustomerDto;


public class BankAccountDto {
	private long id;
	private String number;
	private BigDecimal balance;
	private boolean isLocked;
	private CustomerDto customer;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public boolean isLocked() {
		return isLocked;
	}
	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}
	public CustomerDto getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}
	
}
