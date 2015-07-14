package spring.boot.Thymeleaf.first.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spring.boot.Thymeleaf.first.pojo.Message;

@Controller
@RequestMapping("/messages/")
public class MessagesController {

	
	@RequestMapping(value="list",method=RequestMethod.GET)  
    public ModelAndView list() {  
    
		// Iterable<Message> messages = this.messageRepository.findAll();  
     
		List<Message> messages  = new ArrayList<Message>();
		
		Message msg = null;
		
		for(int i = 0;i<5;i++){
			
			 msg = new Message();
			 msg.setId(i == 1?null:i);
			 msg.setIsTrue(true);
			 msg.setCreated(new Date());
			 msg.setSummary("summary"+i);
			 messages.add(msg);
		}
		
		//return new ModelAndView("messages/list", "messages", messages);  
		//System.out.println("test!");
		
		ModelAndView mv = new ModelAndView("messages/list"); 
		mv.addObject("listTest",new ArrayList<Message>());
		mv.addObject("messages",messages);
		
		return mv;
		//return new ModelAndView("messages/list");  
    }  
  
    @RequestMapping("visit/{id}")  
    public ModelAndView view(@PathVariable("id") String id) {  
    	
    	Message message = new Message();
    	message.setId(Integer.valueOf(id));
    	message.setCreated(new Date());
    	message.setSummary("summary"+id);
    
    	
        return new ModelAndView("messages/view", "message", message);  
    }  
  
    @RequestMapping(value = "createForm", method = RequestMethod.GET)  
    public String createForm(@ModelAttribute Message message) {  
        return "messages/form";  
    }  
  
    @RequestMapping(value = "createForm", method = RequestMethod.POST)  
    public ModelAndView create(@Valid Message message, BindingResult result,  
            RedirectAttributes redirect) {  
        if (result.hasErrors()) {  
            return new ModelAndView("messages/form", "formErrors", result.getAllErrors());  
        }  
       // message = this.messageRepository.save(message);  
        
        message.setId(123);
        
        redirect.addFlashAttribute("globalMessage", "Successfully created a new message");  
        return new ModelAndView("redirect:/messages/visit/{message.id}", "message.id",message.getId());  
    }  
  
    @RequestMapping("foo")  
    public String foo() {  
        throw new RuntimeException("Expected exception in controller");  
    } 
	
	
}
