package com.anudip.librarymanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;
    
    @Column(name = "borrowed_book_id")
    private int borrowedBookId;

    public User(int userId, String username, String password, String email) {
        this(userId, username, password, email, -1);
    }
    
    // initially user will be created with borrowedBookId as -1 [ i.e., no book borrowed yet ]
    public User() {
    	this.borrowedBookId = -1;
    }

    public User(int userId, String username, String password, String email, int borrowedBookId) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.borrowedBookId = borrowedBookId;
	}

	//Constructors
//	public User() {
//		super();
//	}

//	public User(int userId, String username, String password, String email, User role) {
//		super();
//		this.userId = userId;
//		this.username = username;
//		this.password = password;
//		this.email = email;
//	}

	//Getters and setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getBorrowedBookId() {
		return borrowedBookId;
	}

	public void setBorrowedBookId(int borrowedBookId) {
		this.borrowedBookId = borrowedBookId;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", borrowedBookId=" + borrowedBookId + "]";
	}

	public void setUserName(String newUserName) {
		// TODO Auto-generated method stub
		
	}

}
