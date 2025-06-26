import java.util.ArrayList;
import java.util.Scanner;

class Book{
    private String title;
    private String author;
    private boolean isIssued;
    
    Book(String title, String author)
    {
        this.title = title;
        this.author=author;
    }
    
    public String getTitle() {
        return title;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void issue() {
        isIssued = true;
    }

    public void returnBook() {
        isIssued = false;
    }

    @Override
    public String toString() {
        return title + " by " + author + (isIssued ? " [Issued]" : " [Available]");
    }
}

class User{
    private String name;
    private int userId;
    
    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "User: " + name + " (ID: " + userId + ")";
    }
}

class Library{
    private ArrayList <Book> books;
    private ArrayList <User> users;
    private ArrayList <Book> availableBook;
    
    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }
    
    public void addBook(Book book)
    {
        books.add(book);
        System.out.println(book.getTitle() + " added to the library.");
    }
    
    public void addUser(User user)
    {
        users.add(user);
        System.out.println(user.getName() + " added to the User.");
    }
    
    public void issueBook(String bookTitle, int userId)
    {
        for(Book book :books)
        {
            if(book.getTitle().equalsIgnoreCase(bookTitle))
            {
                if(!book.isIssued())
                {
                    book.issue();
                    System.out.println("Book \"" + bookTitle + "\" issued to user ID " + userId);
                    return;
                }
                else{
                    System.out.println("Book is not available");
                }
            }
        }
    }
    
    public void returnBook(String bookTitle) 
    {
        for(Book book :books)
        {
            if(book.getTitle().equalsIgnoreCase(bookTitle))
            {
                if(book.isIssued())
                {
                    book.returnBook();
                    System.out.println("Book \"" + bookTitle + "\" returned.");
                    return;
                }
                else{
                    System.out.println("Book is not issued");
                }
            }
        }
    }
    
    public void showAllBooks(){
        System.out.println("\nBooks in Library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void showAllUsers() {
        System.out.println("\nRegistered Users:");
        for (User user : users) {
            System.out.println(user);
        }
    }
    
    public void search(String title)
    {
        boolean found = false;
        for (Book book : books) 
        {
            if(book.getTitle().equalsIgnoreCase(title))
            {
                found = true;
                if(book.isIssued())
                {
                    System.out.println(book + " not available");
                }
                else{
                    System.out.println(book + " available");
                }
                break ;
            }
        }
        if(!found){
            System.out.println("This book is " + title + " not available");
        }
    }
}

public class LibraryManagement {
	public static void main(String[] args) {
		Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Sample data
        library.addBook(new Book("Mahabharat", "ved vyas"));
        library.addBook(new Book("Ramayan", "Valmiki"));
        library.addUser(new User("Alice", 1));
        library.addUser(new User("Bob", 2));
		
		while (running) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Show Books");
            System.out.println("2. Show Users");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Add Book");
            System.out.println("6. Register User");
            System.out.println("7. Search Book");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    library.showAllBooks();
                    break;
                case 2:
                    library.showAllUsers();
                    break;
                case 3:
                    System.out.print("Enter book title: ");
                    String issueTitle = scanner.nextLine();
                    System.out.print("Enter user ID: ");
                    int userId = scanner.nextInt();
                    library.issueBook(issueTitle, userId);
                    break;
                case 4:
                    System.out.print("Enter book title: ");
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    break;
                case 5:
                    System.out.print("Enter book title: ");
                    String newBookTitle = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String newAuthor = scanner.nextLine();
                    library.addBook(new Book(newBookTitle, newAuthor));
                    break;
                case 6:
                    System.out.print("Enter user name: ");
                    String newUserName = scanner.nextLine();
                    System.out.print("Enter user ID: ");
                    int newUserId = scanner.nextInt();
                    library.addUser(new User(newUserName, newUserId));
                    break;
                case 7: 
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    library. search(title);
                    break;
                case 8:
                    running = false;
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
	}
}
