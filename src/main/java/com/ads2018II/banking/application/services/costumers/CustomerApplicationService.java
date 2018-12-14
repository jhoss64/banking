package com.ads2018II.banking.application.services.costumers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ads2018II.banking.application.Notification;
import com.ads2018II.banking.application.dto.costumers.CustomerDto;
import com.ads2018II.banking.domain.entity.costumers.Customer;
import com.ads2018II.banking.domain.repository.costumers.CustomerRepository;


@Service

public class CustomerApplicationService {
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Value("${maxPageSize}")
	private int maxPageSize;
    
	public CustomerDto create(CustomerDto customerDto) {
		Customer customer = mapper.map(customerDto, Customer.class);
		customer.setIsActive(true);
		customer = customerRepository.save(customer);
		customerDto = mapper.map(customer, CustomerDto.class);
        return customerDto;
    }
	
	public List<CustomerDto> get(int page, int pageSize) {
		Notification notification = this.getValidation(page, pageSize);
        if (notification.hasErrors()) {
            throw new IllegalArgumentException(notification.errorMessage());
        }
		List<Customer> customers = this.customerRepository.get(page, pageSize);
		List<CustomerDto> customersDto = mapper.map(customers, new TypeToken<List<CustomerDto>>() {}.getType());
        return customersDto;
    }
	
	private Notification getValidation(int page, int pageSize) {
		Notification notification = new Notification();
		if (pageSize > maxPageSize) {
			notification.addError("Page size can not be greater than 100");
		}
		return notification;
	}
}
