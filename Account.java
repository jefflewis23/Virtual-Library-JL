package virtualLibrary;

import java.util.ArrayList;

public class Account {
  //Declare variables to be used by this class and child classes (protected)
    Members accountHolder;
    protected int accountNumber;
    protected int numBooksWithdrawn;
    protected ArrayList<Book> checkedOutBooks;


    //Default Constructor
    public Account () {
        accountHolder = new Members();
        accountNumber = 0;
        numBooksWithdrawn = 0;
        checkedOutBooks = new ArrayList<Book>();
    }


    //Non-default Constructor
    public Account (Members accountName, int newAccountNumber) {
        this.accountHolder = accountName;
        this.accountNumber = newAccountNumber;
        this.numBooksWithdrawn = 0;
        this.checkedOutBooks = new ArrayList<Book>();
    }

    
    //Set Methods
    public void setAccountHolder (Members accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void setAccountNumber (int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBooksWithdrawn (int booksWithdrawn) {
        this.numBooksWithdrawn = booksWithdrawn;
    }


    //Get Methods
    public Members getAccountHolder () {
        return this.accountHolder;
    }

    public int getAccountNumber () {
        return this.accountNumber;
    }

    public int getBooksWithdrawn () {
        return this.numBooksWithdrawn;
    }
    
    
    // Class methods
    
    

}
