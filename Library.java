package virtualLibrary;
import java.util.ArrayList;

public class Library {
  //may need an update
    protected ArrayList<Book> books;       // to store available books
    protected ArrayList<Book> catalog;     // to store a catalog of all books (does not change with checking out and returning methods)
    protected ArrayList<Members> members;  // to store members
    protected ArrayList<Account> accounts; // to store user accounts

    public Library() {
        books = new ArrayList<Book>();
        //catalog = new ArrayList<Book>();
        members = new ArrayList<Members>();
        accounts = new ArrayList<Account>();
    }
       
    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
    
    public ArrayList<Book> getCatalog() {
        return catalog;
    }

    public void addMember(Members member) {
        members.add(member);
    }

    public void removeMember(Members member) {
        members.remove(member);
    }

    public ArrayList<Members> getMembers() {
        return members;
    }

    public void addAccount(Account account) {
        for (int i = 0; i < accounts.size(); i++) {
            if (account.accountNumber == accounts.get(i).accountNumber) {
                System.out.println("Account number already exists. Please try again.");
                return;
            }
        }
        accounts.add(account);
        System.out.println("New account created");
    }

    public void removeAccount(Account account) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.contains(account)) {
                accounts.remove(account);
                System.out.println("Account successfully removed.");
                return;
            }
        }
        System.out.println("Account number not found. Please try again.");
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
    
    // Prints the titles of all books currently checked out by an Account
    public void printBooks(Account account) {
        if (account.checkedOutBooks.size() == 0) {
            System.out.println("This account does not currently have any books checked out.");
        } else {
            for (int i = 0; i < account.checkedOutBooks.size(); i++) {
                System.out.println("Book ID: " + account.checkedOutBooks.get(i).bookID + " | " + account.checkedOutBooks.get(i).title + " by " + account.checkedOutBooks.get(i).author);
            }
        }
    }
        
    public void printCatalog() {
        System.out.println("All books currently owned by this library:");
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i).title + " by " + books.get(i).author);
        }
    }
    public void printAvailableBooks() {
        System.out.println("All books currently available:");
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isAvailable()) {
                System.out.println("Book ID: " + books.get(i).bookID + " | " + books.get(i).title + " by " + books.get(i).author);
            }
        }
    }

    public void printAccountInfo() {
        System.out.println("All active accounts:");
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            System.out.println("Account Number: " + account.accountNumber + " | Name: " + account.accountHolder.name);
            System.out.println("Number of books checked out to account: " + account.numBooksWithdrawn);
            System.out.println("Address: " + account.accountHolder.memberAddress + " | Phone: " + account.accountHolder.phone);
        }
    }
    
    public void printAccounts() {
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            System.out.println("Name: " + account.accountHolder.name + " | Account Number: " + account.accountNumber);
        }
    }
    
    public void checkOutBook(Account account, Book book) {
        if (book.isAvailable()) {
            if (account.numBooksWithdrawn < 5) {
                // Makes the book unavailable
                book.available = false;
                // Adds to the number of books "account" has withdrawn (limit 5)
                account.numBooksWithdrawn++;
                account.checkedOutBooks.add(book);
                //removeBook(book);
                System.out.println("Book successfully checked out.");
            } else if (account.numBooksWithdrawn >= 5) {
                System.out.println("This account has already checked out 5 books. Please return a book before checking out any more.");
            }
        } else System.out.println("This book has already been checked out.");
    }
    
    public void returnBook(Account account, Book book) {
        // If the book is actually checked out to the account
        if (account.checkedOutBooks.contains(book)) {
            // Book becomes available again
            book.available = true;
            // Decreases number of books "account" has withdrawn (limit 5)
            account.numBooksWithdrawn--;
            // Removes the book from the list of checked out books
            account.checkedOutBooks.remove(book);
            //addBook(book);
            System.out.println("Book successfully returned.");
        } else System.out.println("This book is not currently checked out by this account.");
    }
    
    public Account findAccount(int accountNumber) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).accountNumber == accountNumber) {
                return accounts.get(i);
            }
        }
        System.out.println("Account number not found.");
        return null;
    }
    
    public Book findBook(int bookID) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).bookID == bookID) {
                return books.get(i);
            }
        }
        System.out.println("Book not found.");
        return null;
    }
    public Book findBookCheckedOut(Account account, int bookID) {
        for (int i = 0; i < account.checkedOutBooks.size(); i++) {
            if (account.checkedOutBooks.get(i).bookID == bookID) {
                return account.checkedOutBooks.get(i);
            }
        }
        System.out.println("Book not found.");
        return null;
    }
  
}
