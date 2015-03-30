package spring.boot.first.mvc.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.boot.first.dao.dbCustomer.po.Customer;
import spring.boot.first.service.service.CustomerService;

@Controller
@RequestMapping("/customer")
@Slf4j
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	//http://localhost:9090/customer/findAll
		@RequestMapping("/findAll")
		public ModelAndView findAll(){
			
			ModelAndView mv = new ModelAndView();
			
			List<Customer> customerList =  customerService.findAll();
			
			log.debug("test debug log!");
			
			log.info("test debug info!");
			
			mv.setViewName("customer/findAll");
			
			mv.addObject("customerList", customerList);
			
			return mv;
		}
	
	
}
