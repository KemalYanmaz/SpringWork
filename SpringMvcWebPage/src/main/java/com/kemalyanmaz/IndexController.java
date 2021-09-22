package com.kemalyanmaz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping("/feedback")
	public String feedback() {
		System.out.println("dasasddsa");
		return "feedback.jsp";
	}
	
}
