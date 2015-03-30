package spring.boot.first.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.boot.first.dao.dbCustomer.CustomerDao;
import spring.boot.first.dao.dbCustomer.po.Customer;
import spring.boot.first.service.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private	CustomerDao customerDao;
	
	
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

}
