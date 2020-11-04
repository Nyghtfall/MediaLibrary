package org.dcate.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {

	@Id
	@GeneratedValue
	private int id;

	@Column
	@NotNull(message = "{NotNull.Book.title}")
	private String title;

	@Column
	@NotNull(message = "{NotNull.Book.author}")
	private String author;

	@Column
	@NotNull(message = "{NotNull.Book.genre}")
	private String genre;

	@Column
	@NotNull(message = "{NotNull.Book.nbrPages}")
	private String nbrPages;

	@Column
	@NotNull(message = "{NotNull.Book.available}")
	private String available;

}
