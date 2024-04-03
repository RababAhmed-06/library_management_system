CREATE DATABASE library_management_system;

USE library_management_system;

CREATE TABLE Author (
    author_id INT AUTO_INCREMENT PRIMARY KEY,
    author_name VARCHAR(100)
);

CREATE TABLE Book (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    author_id INT,
    quantity INT,
    FOREIGN KEY (author_id) REFERENCES Author(author_id)
);

CREATE TABLE Member (
    member_id INT AUTO_INCREMENT PRIMARY KEY,
    member_name VARCHAR(100)
);

CREATE TABLE Issue (
    issue_id INT AUTO_INCREMENT PRIMARY KEY,
    book_id INT,
    member_id INT,
    issue_date DATE,
    due_date DATE,
    FOREIGN KEY (book_id) REFERENCES Book(book_id),
    FOREIGN KEY (member_id) REFERENCES Member(member_id)
);

CREATE TABLE `Return` (
    return_id INT AUTO_INCREMENT PRIMARY KEY,
    issue_id INT,
    return_date DATE,
    fine_amount DECIMAL(10, 2),
    FOREIGN KEY (issue_id) REFERENCES Issue(issue_id)
);

CREATE TABLE Fine (
    fine_id INT AUTO_INCREMENT PRIMARY KEY,
    member_id INT,
    fine_amount DECIMAL(10, 2),
    FOREIGN KEY (member_id) REFERENCES Member(member_id)
);
