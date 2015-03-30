package spring.boot.first.dao.dbOrder;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.boot.first.dao.dbOrder.po.Order;

public interface OrderDao extends JpaRepository<Order, Integer>,OrderDaoCustom {

}
