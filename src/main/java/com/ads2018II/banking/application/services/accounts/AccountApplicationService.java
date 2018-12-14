package com.ads2018II.banking.application.services.accounts;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.NamingConventions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ads2018II.banking.application.Notification;
import com.ads2018II.banking.application.dto.accounts.BankAccountDto;
import com.ads2018II.banking.domain.entity.accounts.BankAccount;
import com.ads2018II.banking.domain.entity.costumers.Customer;
import com.ads2018II.banking.domain.repository.accounts.BankAccountRepository;
import com.ads2018II.banking.domain.repository.costumers.CustomerRepository;


@Service
public class AccountApplicationService {

	@Autowired
	BankAccountRepository bankAccountRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	private ModelMapper mapper;
    
	public BankAccountDto create(long customerId, BankAccountDto bankAccountDto) throws Exception {
		Notification notification = this.createValidation(bankAccountDto);
        if (notification.hasErrors()) {
            throw new IllegalArgumentException(notification.errorMessage());
        }
		BankAccount bankAccount = mapper.map(bankAccountDto, BankAccount.class);
		bankAccount.setLocked(false);
		Customer customer = customerRepository.get(customerId);
		bankAccount.setCustomer(customer);
		bankAccount = bankAccountRepository.save(bankAccount);
		bankAccountDto = mapper.map(bankAccount, BankAccountDto.class);
        return bankAccountDto;
    }
	
	private Notification createValidation(BankAccountDto bankAccountDto) throws Exception {
		Notification notification = new Notification();
		BankAccount bankAccount = bankAccountRepository.findByNumber(bankAccountDto.getNumber());
		if (bankAccount != null) {
			notification.addError("BankAccount number is already registered");
		}
		return notification;
	}
	
	public List<BankAccountDto> get(long customerId) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
	      .setFieldMatchingEnabled(true)
	      .setFieldAccessLevel(AccessLevel.PRIVATE)
	      .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
		List<BankAccount> bankAccounts = this.bankAccountRepository.get(customerId);
		List<BankAccountDto> bankAccountsDto = modelMapper.map(bankAccounts, new TypeToken<List<BankAccountDto>>() {}.getType());
        return bankAccountsDto;
    }
	
}
