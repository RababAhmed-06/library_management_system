package com.anudip.librarymanagement.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TransactionDAO {
    private final SessionFactory sessionFactory;

    // Constructor to initialize the session factory
    public TransactionDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Method to save a transaction into the database
    public void saveTransaction(com.anudip.librarymanagement.entity.Transaction transaction) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(transaction);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Method to retrieve a transaction by ID from the database
    public Transaction getTransactionById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.get(Transaction.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return transaction;
    }

    // Method to retrieve all transactions from the database
    public List<Transaction> getAllTransactions() {
        Session session = sessionFactory.openSession();
        List<Transaction> transactions = null;

        try {
            Query<Transaction> query = session.createQuery("FROM Transaction", Transaction.class);
            transactions = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return transactions;
    }

    // Method to update an existing transaction in the database
    public void updateTransaction(Transaction transaction) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(transaction);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Method to delete a transaction from the database by ID
    public void deleteTransaction(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Transaction transaction = session.get(Transaction.class, id);
            if (transaction != null) {
                session.delete(transaction);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
