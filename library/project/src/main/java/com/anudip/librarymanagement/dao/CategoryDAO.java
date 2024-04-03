package com.anudip.librarymanagement.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.anudip.librarymanagement.entity.Category;

import java.util.List;

public class CategoryDAO {
    private final SessionFactory sessionFactory;

    // Constructor to initialize the session factory
    public CategoryDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Method to save a category into the database
    public void saveCategory(Category category) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(category);
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

    // Method to retrieve a category by ID from the database
    public Category getCategoryById(int id) {
        Session session = sessionFactory.openSession();
        Category category = null;

        try {
            category = session.get(Category.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return category;
    }

    // Method to retrieve all categories from the database
    public List<Category> getAllCategories() {
        Session session = sessionFactory.openSession();
        List<Category> categories = null;

        try {
            Query<Category> query = session.createQuery("FROM Category", Category.class);
            categories = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return categories;
    }

    // Method to update an existing category in the database
    public void updateCategory(Category category) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(category);
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

    // Method to delete a category from the database by ID
    public void deleteCategory(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Category category = session.get(Category.class, id);
            if (category != null) {
                session.delete(category);
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
