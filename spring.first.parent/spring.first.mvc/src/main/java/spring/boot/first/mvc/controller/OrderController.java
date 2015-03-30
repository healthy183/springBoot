package spring.boot.first.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.boot.first.dao.dbOrder.po.Order;
import spring.boot.first.service.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	//http://localhost:9090/order/findAll
	@RequestMapping("/findAll")
	public ModelAndView findAll(){
		
		ModelAndView mv = new ModelAndView();
		
		List<Order> orderList =	orderService.findAll();
		
		mv.setViewName("order/findAll");
		
		mv.addObject("orderList", orderList);
		
		return mv;
	}
	
	
	
}
