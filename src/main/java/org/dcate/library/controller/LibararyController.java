package org.dcate.library.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.dcate.library.entity.Books;
import org.dcate.library.links.BookLinks;
import org.dcate.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/")
public class LibararyController {

	@Autowired
	LibraryService libraryService;

	@GetMapping(path = BookLinks.LIST_BOOKS)
	public ResponseEntity<?> listBooks() {
		log.info("#LibararyController - List Books");
		List<Books> resource = libraryService.getBooks();
		return ResponseEntity.ok(resource);
	}

	@PostMapping(path = BookLinks.BOOK)
	public ResponseEntity<?> addBook(@RequestBody Books book) {
		log.info("#LibararyController - List Books");
		Books resource = libraryService.addBook(book);
		return ResponseEntity.ok(resource);
	}

	@GetMapping(path = BookLinks.BOOK + "/{id}")
	ResponseEntity<?> getBook(@PathVariable Integer id) {
		Optional<Books> book = libraryService.findBook(id);
		return book.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PutMapping(path = BookLinks.BOOK + "/checkin/{id}")
	ResponseEntity<Books> checkinBook(@PathVariable Integer id) {
		log.info("Checking In book: {}", id);
		Books result = libraryService.checkinBook(id);
		return ResponseEntity.ok().body(result);
	}

	@PutMapping(path = BookLinks.BOOK + "/checkout/{id}")
	ResponseEntity<Books> checkoutBook(@PathVariable Integer id) {
		log.info("Checking Out book: {}", id);
		Books result = libraryService.checkoutBook(id);
		return ResponseEntity.ok().body(result);
	}

	@PutMapping(path = BookLinks.BOOK + "/{id}")
	ResponseEntity<Books> updateBook(@Valid @RequestBody Books book) {
		log.info("Request to update an existing book: {}", book);
		Books result = libraryService.saveBook(book);
		return ResponseEntity.ok().body(result);
	}

}
