package library.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DefaultController {
	
    @RequestMapping("/")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	return "hello.html";
    }
   	 
    //InternalResourceViewResolver
}