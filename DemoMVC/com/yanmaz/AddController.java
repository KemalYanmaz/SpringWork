package com.yanmaz;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Controller
public class AddController {

	@RequestMapping("/add")
	public String add() 
	{
		System.out.println("I am here");
		return "display.jsp";
	}
}
