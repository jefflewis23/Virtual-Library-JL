package virtualLibrary;

// INFO-C 211
// Project: Virtual Library
// Author: Jeff Lewis

public class Book {
    
    protected int bookID;
    protected String title;
    protected String author;
    protected boolean available;
    
    /* Class constructors */
    // Default constructor
    public Book() {
        bookID = 0;
        title = "";
        author = "";
        available = true;       
    }
    /* ****** UPDATE AS NEW ATTRIBUTES ARE ADDED ****** */
    public Book(int bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.available = true;
        
    }
    
    // Class getters and setters
    public int getBookID() {
        return bookID;
    }
    public void setBookID(int bookID) {
        this.bookID = bookID;
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }
    
    
    
    // Class methods
   
}
