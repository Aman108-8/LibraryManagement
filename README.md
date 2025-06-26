# LibraryManagement
# 📚 Library Management System (Java Console Application)

This is a **simple console-based Library Management System** written in Java. It allows basic management of books and users, including issuing and returning books, searching by title, and displaying library data.

---

## 💡 Features

- Add new books and users
- Issue and return books
- View all books and registered users
- Search for books by title
  - Shows if the book is available, issued, or not found
- Simple and interactive console menu

---

## 🛠 Technologies Used

- Java (Core Java)
- ArrayList (Java Collections)
- OOP Concepts: Classes, Objects, Encapsulation, toString override
- Scanner for input handling

---

## 🧾 How It Works

### Book Class
- Stores `title`, `author`, and issue status
- Methods to issue, return, and check status

### User Class
- Stores `name` and `user ID`

### Library Class
- Manages:
  - List of books and users
  - Book issuing and returning logic
  - Searching and listing operations

### Menu Options:
1. Show Books  
2. Show Users  
3. Issue Book  
4. Return Book  
5. Add Book  
6. Register User  
7. Search Book  
8. Exit  

---

## 🚀 How to Run

1. Open your favorite Java IDE (e.g., IntelliJ, Eclipse, VS Code).
2. Create a file named `LibraryManagement.java`.
3. Copy and paste the code into it.
4. Compile and run:

```bash
javac LibraryManagement.java
java LibraryManagement
```
--- Library Menu ---
1. Show Books
2. Show Users
3. Issue Book
...
Enter your choice: 3
Enter book title: Ramayan
Enter user ID: 1
Book "Ramayan" issued to user ID 1
