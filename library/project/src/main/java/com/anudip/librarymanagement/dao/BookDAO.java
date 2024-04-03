package com.anudip.librarymanagement.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.anudip.librarymanagement.entity.Book;

import java.util.List;

public class BookDAO {
    private final SessionFactory sessionFactory;

    // Constructor to initialize the session factory
    public BookDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Method to save a book into the database
    public void saveBook(Book book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Method to retrieve a book by ID from the database
    public Book getBookById(int id) {
        Session session = sessionFactory.openSession();
        Book book = null;

        try {
            book = session.get(Book.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return book;
    }

    // Method to retrieve all books from the database
    public List<Book> getAllBooks() {
        Session session = sessionFactory.openSession();
        List<Book> books = null;

        try {
            Query<Book> query = session.createQuery("FROM Book", Book.class);
            books = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return books;
    }

    // Method to update an existing book in the database
    public void updateBook(Book book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(book);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Method to delete a book from the database by ID
    public void deleteBook(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Book book = session.get(Book.class, id);
            if (book != null) {
                session.delete(book);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

//	public void deleteBook(Book bookToDelete) {
//		
//	}
}
