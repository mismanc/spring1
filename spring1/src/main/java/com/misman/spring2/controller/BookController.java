package com.misman.spring2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.misman.spring2.repositories.BookRepository;

@Controller
public class BookController {

	private BookRepository bookRepository;

	public BookController(BookRepository rep) {
		this.bookRepository = rep;
	}

	@RequestMapping("/books")
	public String getBooks(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "books";
	}
}
