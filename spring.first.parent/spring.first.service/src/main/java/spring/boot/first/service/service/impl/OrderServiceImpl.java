package spring.boot.first.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.boot.first.dao.dbOrder.OrderDao;
import spring.boot.first.dao.dbOrder.po.Order;
import spring.boot.first.service.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	
	
	public List<Order> findAll() {
		return orderDao.findAll();
	}

	
	
}
