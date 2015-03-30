package spring.boot.first.dao.dbCustomer;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.boot.first.dao.dbCustomer.po.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>, CustomerDaoCustom {

}
