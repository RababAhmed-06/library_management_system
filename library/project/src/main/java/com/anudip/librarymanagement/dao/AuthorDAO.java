package com.anudip.librarymanagement.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.anudip.librarymanagement.entity.Author;

import java.util.List;

public class AuthorDAO {
    private final SessionFactory sessionFactory;

    // Constructor to initialize the session factory
    public AuthorDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Method to save an author into the database
    public void saveAuthor(Author author) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            session.save(author);
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

    // Method to retrieve an author by ID from the database
    public Author getAuthorById(int id) {
        Session session = sessionFactory.openSession();
        Author author = null;
        
        try {
            author = session.get(Author.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return author;
    }

    // Method to retrieve all authors from the database
    public List<Author> getAllAuthors() {
        Session session = sessionFactory.openSession();
        List<Author> authors = null;
        
        try {
            Query<Author> query = session.createQuery("FROM Author", Author.class);
            authors = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return authors;
    }

    // Method to update an existing author in the database
    public void updateAuthor(Author author) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            session.update(author);
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

    // Method to delete an author from the database by ID
    public void deleteAuthor(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            Author author = session.get(Author.class, id);
            if (author != null) {
                session.delete(author);
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
}
