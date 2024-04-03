package com.anudip.librarymanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;

    @Column(name = "title")
    private String title;

    @Column(name = "isbn")
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "published_year")
    private int publishedYear;
    
    @Column(name = "avialable_copies")
    private int availableCopies;
    
    //Constructors
	public Book() {
		super();
	}
	
	

	public Book(int bookId, String title, String isbn, Author author, Category category, int publishedYear,
			int availableCopies) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.category = category;
		this.publishedYear = publishedYear;
		this.availableCopies = availableCopies;
	}

	public Book(int bookId, String title, String isbn, Author author, Category category, int publishedYear) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.category = category;
		this.publishedYear = publishedYear;
	}

	//Getters and setters
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getPublishedYear() {
		return publishedYear;
	}

	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}
	
	public int getAvailableCopies() {
		return availableCopies;
	}

	public void setAvailableCopies(int availableCopies) {
		this.availableCopies = availableCopies;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", isbn=" + isbn + ", author=" + author + ", category="
				+ category + ", publishedYear=" + publishedYear + ", availableCopies=" + availableCopies + "]";
	}
}