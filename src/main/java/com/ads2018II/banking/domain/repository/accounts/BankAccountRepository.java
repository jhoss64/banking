package com.ads2018II.banking.domain.repository.accounts;

import java.util.List;

import com.ads2018II.banking.domain.entity.accounts.BankAccount;

public interface BankAccountRepository {
	BankAccount findByNumber (String accountNumber) throws Exception;
	BankAccount findByNumberLocked (String accountNumber) throws Exception;
	List<BankAccount> get(long customerId);
	BankAccount persist (BankAccount bankAccount);
	BankAccount save (BankAccount bankAccount);
}
