package com.anudip.librarymanagement.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.anudip.librarymanagement.entity.User;

import java.util.List;

public class UserDAO {
    private final SessionFactory sessionFactory;

    // Constructor to initialize the session factory
    public UserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Method to save a user into the database
    public void saveUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(user);
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

    // Method to retrieve a user by ID from the database
    public User getUserById(int id) {
        Session session = sessionFactory.openSession();
        User user = null;

        try {
            user = session.get(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }
    
    public User getUserByName(String username) {
    	Session session = sessionFactory.openSession();
    	String hql = "FROM User WHERE username = :username";
    	Query<User> query = session.createQuery(hql, User.class);
    	query.setParameter("username", username);
    	User user = query.uniqueResult();
		return user;
    }

    // Method to retrieve all users from the database
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        List<User> users = null;

        try {
            Query<User> query = session.createQuery("FROM User", User.class);
            users = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return users;
    }

    // Method to update an existing user in the database
    public void updateUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(user);
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

    // Method to delete a user from the database by ID
    public void deleteUser(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) {
                session.delete(user);
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
    
    // Method to borrow book
    public void borrowBookById(int bookId, User borrowingUser) {

		Session session = sessionFactory.openSession();
        Transaction transaction = null;
    	
            try {
            	transaction = session.beginTransaction();
                User user = session.get(User.class, borrowingUser.getUserId());
                boolean hasBorrowedBefore = user.getBorrowedBookId() != -1;
            	System.out.println(hasBorrowedBefore + ": has borrowed before.");
            	if(!hasBorrowedBefore) {
                //main logic
                user.setBorrowedBookId(bookId);
                transaction.commit();
                System.out.println("* Book with ID " + bookId + " has been successfully borrowed. *");
            	}else {
            		System.out.println("* First Return previously borrowed book having id ="+borrowingUser.getBorrowedBookId()+" *");
            	}
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            } finally {
                session.close();
            }
    	}
    	
    
    
    
 // Method to return book
//    public void returnBook(User borrowingUser) {
//    	boolean hasBorrowedBefore = borrowingUser.getBorrowedBookId() != -1;
//    	if(!hasBorrowedBefore) {
//    		Session session = sessionFactory.openSession();
//            Transaction transaction = null;
//
//            try {
//                transaction = session.beginTransaction();
//                //main logic
//                System.out.println("* Book having bookId ["+borrowingUser.getBorrowedBookId()+"] has been returned. *");
//                borrowingUser.setBorrowedBookId(-1);
//                transaction.commit();
//            } catch (Exception e) {
//                if (transaction != null) {
//                    transaction.rollback();
//                }
//                e.printStackTrace();
//            } finally {
//                session.close();
//            }
//    	}else {
//    		System.out.println("* No book to be returned. *");
//    	}
//    	
//    }
    
 // Method to return book
    public void returnBook(User borrowingUser) {
        
    	 Session session = sessionFactory.openSession();
         Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                User user = session.get(User.class, borrowingUser.getUserId());
                boolean hasBorrowedBefore = user.getBorrowedBookId() != -1;
            	System.out.println(hasBorrowedBefore + ": has borrowed before.");
                if (hasBorrowedBefore) {
                // main logic
                System.out.println("* Book with ID [" + user.getBorrowedBookId() + "] has been returned. *");
                user.setBorrowedBookId(-1);
                transaction.commit();
                }else {
                    System.out.println("* No book to be returned. *");
                }
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
