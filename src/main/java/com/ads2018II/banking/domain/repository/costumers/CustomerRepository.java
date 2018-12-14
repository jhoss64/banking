package com.ads2018II.banking.domain.repository.costumers;

import java.util.List;

import com.ads2018II.banking.domain.entity.costumers.Customer;

public interface CustomerRepository {
		public Customer save (Customer customer);
		public List<Customer> get(int page, int pageSize);
		public Customer get(long customerId);
}
