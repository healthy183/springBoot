package spring.boot.first.service.service;

import java.util.List;

import spring.boot.first.dao.dbCustomer.po.Customer;

public interface CustomerService {

	List<Customer> findAll();

}
