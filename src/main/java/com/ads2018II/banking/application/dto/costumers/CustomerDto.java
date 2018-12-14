package com.ads2018II.banking.application.dto.costumers;

import java.util.Set;

import com.ads2018II.banking.application.dto.accounts.BankAccountDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerDto {
	private long id;
	private String firstName;
	private String lastName;
	private Boolean isActive;
	private Set<BankAccountDto> bankAccountsDto;
	
	public CustomerDto() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@JsonProperty(value="inActive")
	public Boolean IsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Set<BankAccountDto> getBankAccountsDto() {
		return bankAccountsDto;
	}

	public void setBankAccountsDto(Set<BankAccountDto> bankAccountsDto) {
		this.bankAccountsDto = bankAccountsDto;
	}
}
