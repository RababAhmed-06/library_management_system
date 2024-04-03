package com.anudip.librarymanagement.main;

import com.anudip.librarymanagement.dao.AuthorDAO;
import com.anudip.librarymanagement.dao.BookDAO;
import com.anudip.librarymanagement.dao.CategoryDAO;
import com.anudip.librarymanagement.dao.TransactionDAO;
import com.anudip.librarymanagement.dao.UserDAO;
import com.anudip.librarymanagement.entity.Author;
import com.anudip.librarymanagement.entity.Book;
import com.anudip.librarymanagement.entity.Category;
import com.anudip.librarymanagement.entity.Transaction;
import com.anudip.librarymanagement.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class Main {

    // Create Hibernate SessionFactory
    static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	//Instantiate DAO classes
    static AuthorDAO authorDAO = new AuthorDAO(sessionFactory);
    static CategoryDAO categoryDAO = new CategoryDAO(sessionFactory);
    static BookDAO bookDAO = new BookDAO(sessionFactory);
    static UserDAO userDAO = new UserDAO(sessionFactory);
    static TransactionDAO transactionDAO = new TransactionDAO(sessionFactory);
    public static void main(String[] args) {
       

        

        Scanner scanner = new Scanner(System.in);
        
        initialMenu(scanner);
        

//        try {
//            // Create operations
//        	// Prompt user for author details
//            System.out.println("Enter author name:");
//            String authorName = scanner.nextLine();
//            Author author = new Author();
//            author.setAuthorName(authorName);
//            authorDAO.saveAuthor(author);
//
//            // Prompt user for category details
//            System.out.println("Enter category name:");
//            String categoryName = scanner.nextLine();
//            Category category = new Category();
//            category.setCategoryName(categoryName);
//            categoryDAO.saveCategory(category);
//
//            // Prompt user for book details
//            System.out.println("Enter book title:");
//            String bookTitle = scanner.nextLine();
//            System.out.println("Enter ISBN:");
//            String isbn = scanner.nextLine();
//            System.out.println("Enter published year:");
//            int publishedYear = scanner.nextInt();
//            scanner.nextLine(); // consume newline
//            Book book = new Book();
//            book.setTitle(bookTitle);
//            book.setIsbn(isbn);
//            book.setAuthor(author);
//            book.setCategory(category);
//            book.setPublishedYear(publishedYear);
//            bookDAO.saveBook(book);
//
//            // Prompt user for user details
//            System.out.println("Enter username:");
//            String username = scanner.nextLine();
//            System.out.println("Enter password:");
//            String password = scanner.nextLine();
//            System.out.println("Enter email:");
//            String email = scanner.nextLine();
//            User user = new User();
//            user.setUsername(username);
//            user.setPassword(password);
//            user.setEmail(email);
//            userDAO.saveUser(user);
//
//            Transaction transaction = new Transaction();
//            transaction.setUser(user);
//            transaction.setBook(book);
//            transaction.setIssueDate(java.sql.Date.valueOf("2024-03-16"));
//            transactionDAO.saveTransaction(transaction);
//
//            // Read operations
//            System.out.println("List of Authors:");
//            List<Author> authors = authorDAO.getAllAuthors();
//            for (Author a : authors) {
//                System.out.println(a.getAuthorName());
//            }
//
//            System.out.println("List of Categories:");
//            List<Category> categories = categoryDAO.getAllCategories();
//            for (Category c : categories) {
//                System.out.println(c.getCategoryName());
//            }
//
//            System.out.println("List of Books:");
//            List<Book> books = bookDAO.getAllBooks();
//            for (Book b : books) {
//                System.out.println(b.getTitle());
//            }
//
//            System.out.println("List of Users:");
//            List<User> users = userDAO.getAllUsers();
//            for (User u : users) {
//                System.out.println(u.getUsername());
//            }
//
//            
//            // Update operation for Author
//            System.out.println("Enter the ID of the author you want to update:");
//            int authorIdToUpdate = scanner.nextInt();
//            scanner.nextLine(); // consume newline
//            Author authorToUpdate = authorDAO.getAuthorById(authorIdToUpdate);
//            if (authorToUpdate != null) {
//                System.out.println("Enter the new name for the author:");
//                String newAuthorName = scanner.nextLine();
//                authorToUpdate.setAuthorName(newAuthorName);
//                authorDAO.updateAuthor(authorToUpdate);
//                System.out.println("Author updated successfully.");
//            } else {
//                System.out.println("Author not found with the given ID.");
//            }
//            
//         // Update operation for Category
//            System.out.println("Enter the ID of the category you want to update:");
//            int categoryIdToUpdate = scanner.nextInt();
//            scanner.nextLine(); // consume newline
//            Category categoryToUpdate = categoryDAO.getCategoryById(categoryIdToUpdate);
//            if (categoryToUpdate != null) {
//                System.out.println("Enter the new name for the category:");
//                String newCategoryName = scanner.nextLine();
//                categoryToUpdate.setCategoryName(newCategoryName);
//                categoryDAO.updateCategory(categoryToUpdate);
//                System.out.println("Category updated successfully.");
//            } else {
//                System.out.println("Category not found with the given ID.");
//            }
//
//            // Update operation for Book
//            System.out.println("Enter the ID of the book you want to update:");
//            int bookIdToUpdate = scanner.nextInt();
//            scanner.nextLine(); // consume newline
//            Book bookToUpdate = bookDAO.getBookById(bookIdToUpdate);
//            if (bookToUpdate != null) {
//                System.out.println("Enter the new title for the book:");
//                String newBookTitle = scanner.nextLine();
//                System.out.println("Enter the new author ID for the book:");
//                int newAuthorId = scanner.nextInt();
//                scanner.nextLine(); // consume newline
//                Author newAuthor = authorDAO.getAuthorById(newAuthorId);
//                if (newAuthor != null) {
//                    bookToUpdate.setTitle(newBookTitle);
//                    bookToUpdate.setAuthor(newAuthor);
//                    bookDAO.updateBook(bookToUpdate);
//                    System.out.println("Book updated successfully.");
//                } else {
//                    System.out.println("Author not found with the given ID. Book update aborted.");
//                }
//            } else {
//                System.out.println("Book not found with the given ID.");
//            }
//
//            // Update operation for User
//            System.out.println("Enter the ID of the user you want to update:");
//            int userIdToUpdate = scanner.nextInt();
//            scanner.nextLine(); // consume newline
//            User userToUpdate = userDAO.getUserById(userIdToUpdate);
//            if (userToUpdate != null) {
//                System.out.println("Enter the new name for the user:");
//                String newUserName = scanner.nextLine();
//                userToUpdate.setUserName(newUserName);
//                userDAO.updateUser(userToUpdate);
//                System.out.println("User updated successfully.");
//            } else {
//                System.out.println("User not found with the given ID.");
//            }
//
//
//         // Delete operation for Category
//            System.out.println("Enter the ID of the category you want to delete:");
//            int categoryIdToDelete = scanner.nextInt();
//            categoryDAO.deleteCategory(categoryIdToDelete);
//            System.out.println("Category deleted successfully.");
//            
//         // Delete operation for Book
//            System.out.println("Enter the ID of the book you want to delete:");
//            int bookIdToDelete = scanner.nextInt();
//            scanner.nextLine(); // consume newline
//            Book bookToDelete = bookDAO.getBookById(bookIdToDelete);
//            if (bookToDelete != null) {
//                bookDAO.deleteBook(bookToDelete);
//                System.out.println("Book deleted successfully.");
//            } else {
//                System.out.println("Book not found with the given ID.");
//            }
//
//            // Delete operation for User
//            System.out.println("Enter the ID of the user you want to delete:");
//            int userIdToDelete = scanner.nextInt();
//            scanner.nextLine(); // consume newline
//            User userToDelete = userDAO.getUserById(userIdToDelete);
//            if (userToDelete != null) {
//                userDAO.deleteUser(userToDelete);
//                System.out.println("User deleted successfully.");
//            } else {
//                System.out.println("User not found with the given ID.");
//            }
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            // Close the SessionFactory
//            sessionFactory.close();
//            // Close the scanner
//            scanner.close();
//        }
    }
    
    
    
//    MENU SECTION
    public static void initialMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("******************************");
            System.out.println("*            Menu            *");
            System.out.println("******************************");
            System.out.println("1. Register User");
            System.out.println("2. Login User");
            System.out.println("3. Add New Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    regUserMenu(scanner);
                    break;
                case 2:
                    User userExists = loginUser(scanner);
                    if(userExists != null) {
                    	loggedInUserMenu(scanner,userExists);
                    }
                    break;
                case 3:
                    System.out.println("Adding a new book...");
                    addNewBook(scanner);
                    break;
                case 4:
                    System.out.println("\nExiting...");
                    break;
                default:
                    System.out.println("\nInvalid choice! Please enter a valid option.\n");
            }
        } while (choice != 4);
    }
    
    public static void regUserMenu(Scanner scanner) {	
        	System.out.println("******************************");
            System.out.println("*      User Registeratin     *");
            System.out.println("******************************");
            // Prompt user for user details
            System.out.println("Enter username:");
            String username = scanner.nextLine();
            System.out.println("Enter password:");
            String password = scanner.nextLine();
            System.out.println("Enter email:");
            String email = scanner.nextLine();
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            userDAO.saveUser(user);
    }
    
    public static void loggedInUserMenu(Scanner scanner, User user) {
    	int choice;

        do {
            System.out.println("******************************");
            System.out.println("*         Sub Menu           *");
            System.out.println("******************************");
            System.out.println("1. View Books");
            System.out.println("2. View Authors");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Logout -> Back to Main Menu");
            System.out.println("******************************");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAllBooks();
                    break;
                case 2:
                	viewAllAuthors();
                    break;
                case 3:
                    System.out.println("Borrow Book");
                    borrowBook(scanner,user);
                    break;
                case 4:
                	returnBook(user);
                    break;
                case 5:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 5);
    }
    
    
    //MENU SECTION ENDS HERE
    
    public static void regAuthor(Scanner scanner) {
    	System.out.println("Enter author name:");
        String authorName = scanner.nextLine();
        Author author = new Author();
        author.setAuthorName(authorName);
		authorDAO.saveAuthor(author);
    }
    
    
    public static User loginUser(Scanner scanner) {
        System.out.println("******************************");
        System.out.println("*         Login User         *");
        System.out.println("******************************");

        System.out.println("Enter User Name:");
        String userName = scanner.nextLine();

        System.out.print("Enter Password:");
        String password = scanner.nextLine();

        System.out.println("******************************");

        // Attempt to retrieve user by username from the database
        User loginUser = userDAO.getUserByName(userName);

        if (loginUser != null) {
            // User found in the database
            System.out.println("* User found.                *");

            // Check if the password matches
            if (loginUser.getPassword().equals(password)) {
                // Password matches
                System.out.println("* Login successful.          *");
                // Proceed with further actions for logged-in user
            } else {
                // Password does not match
                System.out.println("* Incorrect password.(retry) *");
                // If incorrect passwrod return null
                return null;
                // Handle incorrect password scenario, e.g., prompt for password again or provide options
            }
        } else {
            // User not found in the database
            System.out.println("* User not found.           *");
            // Handle user not found scenario, e.g., prompt to register or retry login
        }

        System.out.println("******************************");
        
        return loginUser;
    }
    
    public static void addNewBook(Scanner scanner) {
        // Prompt user for author details
        System.out.println("\n******************************");
        System.out.println("*        Add New Book        *");
        System.out.println("******************************");
        System.out.println("Enter author name:");
        String authorName = scanner.nextLine();
        Author author = new Author();
        author.setAuthorName(authorName);
        authorDAO.saveAuthor(author);

        // Prompt user for category details
        System.out.println("\nEnter category name:");
        String categoryName = scanner.nextLine();
        Category category = new Category();
        category.setCategoryName(categoryName);
        categoryDAO.saveCategory(category);

        // Prompt user for book details
        System.out.println("\nEnter book title:");
        String bookTitle = scanner.nextLine();
        System.out.println("Enter ISBN:");
        String isbn = scanner.nextLine();
        System.out.println("Enter published year:");
        int publishedYear = scanner.nextInt();
        scanner.nextLine(); // consume newline
        Book book = new Book();
        book.setTitle(bookTitle);
        book.setIsbn(isbn);
        book.setAuthor(author);
        book.setCategory(category);
        book.setPublishedYear(publishedYear);
        bookDAO.saveBook(book);

        System.out.println("\nBook added successfully!");
    }
    
    //LOGGED IN USER MENU METHODS
    public static void viewAllBooks() {
        System.out.println("**************************************");
        System.out.println("*        List of Books               *");
        System.out.println("**************************************");
        System.out.println("* ID  | Title");

        List<Book> books = bookDAO.getAllBooks();
        String bookTitle = null;
        for (Book b : books) {
        	bookTitle = b.getTitle().substring(0,1).toUpperCase() + b.getTitle().substring(1);
            System.out.println("* " + String.format("%-4d", b.getBookId()) + "| " + bookTitle);
        }

        System.out.println("**************************************");
    }
    
    public static void viewAllAuthors() {
        System.out.println("**************************************");
        System.out.println("*         List of Authors            *");
        System.out.println("**************************************");
        System.out.println("* ID  | Author Name");

        List<Author> authors = authorDAO.getAllAuthors();
        for (Author author : authors) {
            System.out.println("* " + String.format("%-4d", author.getAuthorId()) + "| " + author.getAuthorName().substring(0,1).toUpperCase()+author.getAuthorName().substring(1));
        }

        System.out.println("**************************************");
    }
    

    public static void borrowBook(Scanner scanner, User borrowingUser) {
        System.out.println("**************************************");
        System.out.println("*          Borrowing Book            *");
        System.out.println("**************************************");
        viewAllBooks();
        do {
            System.out.println("* Enter Book ID from the list above to borrow: *");
            int bookId = scanner.nextInt();
            // Checking if the book exists with the provided bookId
            if (bookDAO.getBookById(bookId) != null) {
                userDAO.borrowBookById(bookId, borrowingUser);
                break;
            } else {
                System.out.println("* No book found with ID = " + bookId + " *");
            }
        } while (true);
        System.out.println("**************************************");
    }

    
    public static void returnBook(User borrowingUser) {
        System.out.println("**************************************");
        System.out.println("*            Returning Book          *");
        System.out.println("**************************************");

        // Call DAO method to return book for the user
        userDAO.returnBook(borrowingUser);

        System.out.println("**************************************");
    }

    
}


