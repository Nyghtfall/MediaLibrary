package org.dcate.library.repository;

import org.dcate.library.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface LibraryRepository extends JpaRepository<Books, Integer>, JpaSpecificationExecutor<Books>, QuerydslPredicateExecutor<Books> {}
