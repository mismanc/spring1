package com.misman.spring2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.misman.spring2.repositories.AuthorRepository;

@Controller
public class AuthorController {
	
	private AuthorRepository authorRepository;

	public AuthorController(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	@RequestMapping("/auths")
	public String getAuthors(Model model){
		model.addAttribute("auts", authorRepository.findAll());
		return "authors";
	}

}
