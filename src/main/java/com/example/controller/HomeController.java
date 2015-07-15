package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	
	@RequestMapping("/")
    public  String helloworld(HttpServletRequest request){
    	return "index";
    }

	@RequestMapping("/guide")
	public String guide()
	{
		
		return "guide";
	}


}
