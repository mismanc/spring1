package com.misman.spring2.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.misman.model.Author;
import com.misman.model.Book;
import com.misman.spring2.repositories.AuthorRepository;
import com.misman.spring2.repositories.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		init();
	}
	
	private void init() {
		// Necip Fazıl Kısakürek
		Author nfk = new Author("Necip Fazıl", "Kısakürek");
		Book io = new Book("İdeolocya Örgüsü", "698585845", "Büyük Doğu Yayınları");
		nfk.getBooks().add(io);
		io.getAuthors().add(nfk);

		authorRepository.save(nfk);
		bookRepository.save(io);
		
		// Aliyaizzet Begoviç
		Author aliya = new Author("Aliyaizzet", "Begoviç");
		Book b2 = new Book("Özgürlüğe Kaçışım", "7895522545", "Klasik Yayınları");
		aliya.getBooks().add(b2);
		
		authorRepository.save(aliya);
		bookRepository.save(b2);
	}

}
