package com.ads2018II.banking.domain.entity.accounts;

import java.math.BigDecimal;

import com.ads2018II.banking.application.Notification;
import com.ads2018II.banking.domain.entity.costumers.*;

public class BankAccount {
	private long id;
	private String number;
	private BigDecimal balance;
	private boolean isLocked;
	private Customer customer;
	
	public BankAccount() {
		
	}
	
	public void lock() {
		if (!this.isLocked) {
			this.isLocked = true;
		}
	}
	
	public void unLock() {
		if (!this.isLocked) {
			this.isLocked = false;
		}
	}
	
	public boolean hasIdentity() {
		return !this.number.trim().equals("");
	}
	
	public void withdrawMoney (BigDecimal amount) {
		Notification notification = this.withdrawValidation(amount);
		if(notification.hasErrors()) {
			throw new IllegalArgumentException(notification.errorMessage());
		}
		this.balance = this.balance.subtract(amount);
	}
	
	public void depositMoney(BigDecimal amount) {
		Notification notification = this.depositValidation(amount);
		if(notification.hasErrors()) {
			throw new IllegalArgumentException(notification.errorMessage());
		}
		this.balance = this.balance.add(amount);
	}

	public Notification withdrawValidation(BigDecimal amount) {
		Notification notification = new Notification();
		this.validateAmount(notification, amount);
		this.validateBankAccount(notification);
		this.validateBalance(notification, amount);
		return notification;
		
	}
	
	private void validateBalance(Notification notification, BigDecimal amount) {
		if(this.balance == null) {
			notification.addError("El balance no puede ser nulo");
		}
		if(!this.canBeWithdrawed(amount)) {
			notification.addError("Cannot withdraw in the account, amount is greater than balance");
		}
	}

	public boolean canBeWithdrawed(BigDecimal amount) {
		// TODO Auto-generated method stub
		return !this.isLocked && (this.balance.compareTo(amount)>=0);
	}

	private void validateBankAccount(Notification notification) {
		if(!this.hasIdentity()) {
			notification.addError("La cuenta no tiene identificacion");
		}
		if(this.isLocked) {
			notification.addError("la cuenta esta bloqueada");
		}
		
	}

	private void validateAmount(Notification notification, BigDecimal amount) {
		if(amount==null) {
			notification.addError("Monto esta vacio");
			return;
		}
		if (amount.signum()<=0) {
			notification.addError("El monto debe ser mayor a cero");
		}
		
	}

	public Notification depositValidation(BigDecimal amount) {
		Notification notification = new Notification();
		this.validateAmount(notification, amount);
		this.validateBankAccount(notification);
		this.validateBalance(notification, amount);
		return notification;
	}

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

	public boolean getIsLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
