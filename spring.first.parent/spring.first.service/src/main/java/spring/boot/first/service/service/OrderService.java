package spring.boot.first.service.service;

import java.util.List;

import spring.boot.first.dao.dbOrder.po.Order;

public interface OrderService {

	List<Order> findAll();

}
