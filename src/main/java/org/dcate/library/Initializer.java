package org.dcate.library;

import org.dcate.library.entity.Books;
import org.dcate.library.repository.LibraryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements CommandLineRunner {

	private final LibraryRepository repository;

	public Initializer(LibraryRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... args) throws Exception {
		repository.save(new Books(-1, "The Walking Drum", "Louis L'Amour", "Historical Fiction", "350", "Yes"));
		repository.save(new Books(-1, "Woods Outback", "RA Salvatore", "Fantasy", "178", "Yes"));
		repository.save(new Books(-1, "Art of War", "Sun Tsu", "Military", "134", "Yes"));
		repository.save(new Books(-1, "Lord of the Rings", "JR Tolkien", "Fantasy", "573", "Yes"));
		repository.save(new Books(-1, "Pragmatic Programmer", "Andy Hunt", "Programming", "217", "Yes"));
		repository.save(new Books(-1, "1984", "George Orwell", "Fiction", "145", "Yes"));
		repository.save(new Books(-1, "The Diary of a Young Girl", "Anne Frank", "Biography", "244", "Yes"));

		repository.findAll().forEach(System.out::println);
	}

}
