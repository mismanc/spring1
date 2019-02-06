package com.misman.spring2.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.misman.model.Author;
import com.misman.model.Book;
import com.misman.model.Publisher;
import com.misman.spring2.repositories.AuthorRepository;
import com.misman.spring2.repositories.BookRepository;
import com.misman.spring2.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publishRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publishRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publishRepository = publishRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		init();
	}
	
	private void init() {
		// Necip Fazıl Kısakürek
		Author nfk = new Author("Necip Fazıl", "Kısakürek");
		Publisher p = new Publisher("Büyük Doğu Yayınları");
		Book io = new Book("İdeolocya Örgüsü", "698585845", p);
		
		nfk.getBooks().add(io);
		io.getAuthors().add(nfk);

		publishRepository.save(p);
		authorRepository.save(nfk);
		bookRepository.save(io);
		
		// Aliyaizzet Begoviç
		Author aliya = new Author("Aliyaizzet", "Begoviç");
		Publisher p2 = new Publisher("Klasik Yayınları");
		Book b2 = new Book("Özgürlüğe Kaçışım", "7895522545", p2);
		aliya.getBooks().add(b2);
		
		publishRepository.save(p2);
		authorRepository.save(aliya);
		bookRepository.save(b2);
	}

}
