package com.misman.spring2.repositories;

import org.springframework.data.repository.CrudRepository;

import com.misman.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	
}
