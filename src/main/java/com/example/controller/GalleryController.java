package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.repository.ArticleRepository;

@Controller
@RequestMapping("/gallery")
public class GalleryController {
	
	@Autowired
	ArticleRepository repository;

	@RequestMapping
	public String hello(Model model)
	{
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		model.addAttribute("articles", repository.findAll(sort));
		return "gallery";
	}

}
