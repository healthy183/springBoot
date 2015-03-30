package spring.boot.first.dao.dbCustomer.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import spring.boot.first.common.dao.BaseJpaDaoImpl;
import spring.boot.first.dao.dbCustomer.CustomerDaoCustom;
import spring.boot.first.dao.dbCustomer.po.Customer;

public class CustomerDaoCustomImpl extends  BaseJpaDaoImpl<Customer,Integer>   implements CustomerDaoCustom{

	private EntityManager entityManager;
	
	@Override
	@PersistenceContext(unitName="customerPersistenceUnit")
	public void setEntityManager(EntityManager superEntityManager) {
		this.superEntityManager = superEntityManager;
		this.entityManager = superEntityManager;
	}

}
