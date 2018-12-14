package com.ads2018II.banking.infraestructure.costumers;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ads2018II.banking.domain.entity.costumers.Customer;
import com.ads2018II.banking.domain.repository.costumers.CustomerRepository;
import com.ads2018II.banking.infraestructure.common.hibernate.BaseHibernateRepository;

@Transactional
@Repository
public class CustomerHibernateRepository extends BaseHibernateRepository<Customer> implements CustomerRepository {
	public Customer get(long customerId) {
		Customer customer = null;
		customer = getSession().get(Customer.class, customerId);
		return customer;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> get(int page, int pageSize) {
		List<Customer> customers = null;
		Criteria criteria = getSession().createCriteria(Customer.class);
		criteria.setFirstResult(page);
		criteria.setMaxResults(pageSize);
		customers = criteria.list();
		return customers;
	}
	
	public Customer save(Customer customer) {
		return super.save(customer);
	}
}
