package com.misman.spring2.repositories;

import org.springframework.data.repository.CrudRepository;

import com.misman.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{
	
	

}
