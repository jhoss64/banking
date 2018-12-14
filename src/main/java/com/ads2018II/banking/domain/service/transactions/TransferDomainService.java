package com.ads2018II.banking.domain.service.transactions;

import java.math.BigDecimal;

import com.ads2018II.banking.application.Notification;
import com.ads2018II.banking.domain.entity.accounts.BankAccount;

public class TransferDomainService {

	public void performTransfer(BankAccount originAccount, BankAccount destinationAccount, BigDecimal amount) 
	throws IllegalArgumentException{
		Notification notification = this.validation(originAccount,destinationAccount,amount);
		if(notification.hasErrors()) {
			throw new IllegalArgumentException(notification.errorMessage());
		}
		originAccount.withdrawMoney(amount);
		destinationAccount.depositMoney(amount);
	}

	private Notification validation(BankAccount originAccount, BankAccount destinationAccount, BigDecimal amount) {
		// TODO Auto-generated method stub
		Notification notification = new Notification();
		this.validateAmount(notification,amount);
		this.validateBankAccounts(notification,originAccount,destinationAccount);
		return notification;
	}

	private void validateBankAccounts(Notification notification, BankAccount originAccount,
			BankAccount destinationAccount) {
		if(originAccount==null || destinationAccount==null) {
			notification.addError("No se pudo procesar la transferencia. Datos invalidos en las cuentas especificadas");
		}
		if(originAccount.getNumber().equals(destinationAccount.getNumber())) {
			notification.addError("No se puede transferir a la misma cuenta bancaria");
		}
	}

	private void validateAmount(Notification notification, BigDecimal amount) {
		if(amount==null) {
			notification.addError("Cuenta esta perdida");
		}
		if(amount.signum()<=0) {
			notification.addError("La cuenta debe ser mayor a cero");
		}
	}
}
