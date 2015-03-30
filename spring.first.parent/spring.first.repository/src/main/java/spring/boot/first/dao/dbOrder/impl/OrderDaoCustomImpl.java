package spring.boot.first.dao.dbOrder.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import spring.boot.first.common.dao.BaseJpaDaoImpl;
import spring.boot.first.dao.dbOrder.OrderDaoCustom;
import spring.boot.first.dao.dbOrder.po.Order;

public class OrderDaoCustomImpl extends  BaseJpaDaoImpl<Order,Integer>  implements OrderDaoCustom {

	private EntityManager entityManager;
	
	@Override
	@PersistenceContext(unitName="orderPersistenceUnit")
	public void setEntityManager(EntityManager superEntityManager) {
		this.superEntityManager = superEntityManager;
		this.entityManager = superEntityManager;
	}

}
