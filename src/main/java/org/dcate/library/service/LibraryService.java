package org.dcate.library.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.dcate.library.entity.Books;
import org.dcate.library.repository.LibraryRepository;
import org.springframework.stereotype.Component;

@Component
public class LibraryService {

	private LibraryRepository libraryRepository;

	public LibraryService(LibraryRepository libraryRepository) {
		this.libraryRepository = libraryRepository;
	}

	public List<Books> getBooks() {
		return libraryRepository.findAll();
	}

	public Books addBook(Books books) {
		books.setId(new Random().nextInt());
		books.setAvailable("Yes");
		return libraryRepository.save(books);
	}

	public Optional<Books> findBook(Integer id) {
		return libraryRepository.findById(id);
	}

	public Books saveBook(Books book) {
		return libraryRepository.save(book);
	}

	public Books checkoutBook(Integer id) {
		Optional<Books> book = libraryRepository.findById(id);
		Books foundBook = book.get();
		foundBook.setAvailable("No");
		return libraryRepository.save(foundBook);
	}

	public Books checkinBook(Integer id) {
		Optional<Books> book = libraryRepository.findById(id);
		Books foundBook = book.get();
		foundBook.setAvailable("Yes");
		return libraryRepository.save(foundBook);
	}

}
