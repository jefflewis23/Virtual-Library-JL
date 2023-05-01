package virtualLibrary;
import java.util.Scanner;

public class LibraryTest {
    
    static boolean quit = false;
    static Scanner scan = new Scanner(System.in);
    static Library library = new Library();
    
    public static void printMenu() {
        // Maybe switch around the menu layout
        System.out.println("Possible actions:");
        System.out.println("0 - Quit");
        System.out.println("1 - Create new Account");
        System.out.println("2 - Remove an Account");
        System.out.println("3 - Check out a Book to an Account");
        System.out.println("4 - Return a book");
        System.out.println("5 - Print all Books in the catalog");
        System.out.println("6 - Print all Books currently available");
        System.out.println("7 - Print all Books checked out by an Account");
        System.out.println("8 - Print all Accounts");
    }
    
    public static void performAction(int choice) {
        int accountNumber;
        Account account;
        int selection;
        Book bookSelection;
        switch(choice) {
        case 0:
            quit = true;
            break;
        case 1:
            // Create new Account
            System.out.println("Please enter first name");
            String first = scan.next();
            System.out.println("Please enter last name");
            String last = scan.next();
            
            // Clears the line and moves scanner to the next line
            scan.nextLine();
            
            System.out.println("Please enter a street address");
            String address = scan.nextLine();
            System.out.println("Please enter a phone number");
            String phone = scan.next();
            System.out.println("Please enter an account number");
            accountNumber = scan.nextInt();
            // Concatenates the first and last name. nextLine() is weird and can cause issues so this is the easiest way to read first and last name
            String name = first + " " + last;
            Account newAccount = new Account(new Members(name, address, phone), accountNumber);
            library.addAccount(newAccount);
 
            break;
        case 2:
            // Remove an account (return all books checked out to the library first)
            System.out.println("Please select an account by account number ONLY:");
            library.printAccounts();
            accountNumber = scan.nextInt();
            account = library.findAccount(accountNumber);
            if (account != null) {
                if (account.numBooksWithdrawn != 0) {
                    System.out.println("Please return all books before removing this account.");
                } else {
                    library.removeAccount(account);
                }
            }
            break;
        case 3:
            // Check out a Book to an Account
            System.out.println("Please select an account by account number ONLY:");
            library.printAccounts();
            accountNumber = scan.nextInt();
            account = library.findAccount(accountNumber);
            if (account != null) {
                System.out.println("Please select a book by book ID:");
                library.printAvailableBooks();
                selection = scan.nextInt();
                bookSelection = library.findBook(selection);
                if (bookSelection != null) {
                    library.checkOutBook(account, bookSelection);
                } else System.out.println("Operation unsucessful.");
            }

            break;
        case 4: 
         // Return a book from an account
            // ****Weird behavior going on here: not showing the correct book IDs when printing list of books. They are stored correctly in the array but not printing correctly
            System.out.println("Please select an account by account number ONLY:");
            library.printAccounts();
            accountNumber = scan.nextInt();
            account = library.findAccount(accountNumber);
            if (account != null) {
                // Need this if statement because for some reason if the printBooks method is called and the account has no books checked out,
                // it breaks the while loop
                if (account.checkedOutBooks.size() != 0) {
                    System.out.println("Please select a book by book ID:");
                    library.printBooks(account);
                    selection = scan.nextInt();
                    bookSelection = library.findBookCheckedOut(account, selection);
                    if (bookSelection != null) {
                        library.returnBook(account, bookSelection);
                    } else System.out.println("Operation unsuccessful");
                } else System.out.println("This account does not have any books checked out.");
            }
            break;

        case 5:
            // Print all books in the catalog 
            library.printCatalog();
            break;
        case 6:
            // Print all books currently available (all books in the books array (since books are removed when checked out)
            library.printAvailableBooks();
            break;

        case 7:
            // Print all books checked out by an Account
            System.out.println("Please select an account by account number ONLY:");
            library.printAccounts();
            accountNumber = scan.nextInt();
            account = library.findAccount(accountNumber);
            // If the account was found, call the printBooks method
            if (account != null) {
                System.out.println("Books checked out by " + account.accountHolder.name + ":");
                library.printBooks(account);
            } else System.out.println("Operation unsuccessful");
            break;
            
            
        case 8: 
            // Print all accounts
            library.printAccountInfo();
            break;
        default:
            System.out.println("Unknown option. Try again");
            break;
        }
    }

    public static void main(String[] args) {
        
        Book book1 = new Book(1, "The Hunger Games", "Suzanne Collins");
        Book book2 = new Book(2, "The Outsiders", "S. E. Hinton");
        Book book3 = new Book(3, "Lord of the Flies", "William Golding");
        Book book4 = new Book(4, "Holes", "Louis Sachar");
        Book book5 = new Book(5, "A Wrinkle in Time", "Madeleine L'Engle");
        Book book6 = new Book(6, "The Giver", "Lois Lowry");
        Book book7 = new Book(7, "The Book Thief", "Markus Zusak");
        Book book8 = new Book(8, "The Catcher in the Rye", "J. D. Salinger");
        Book book9 = new Book(9, "The Great Gatsby", "F. Scott Fitzgerald");
        Book book10 = new Book(10, "Divergent", "Veronica Roth");
        Book book11 = new Book(11, "The Lord of the Rings", "J. R. R. Tolkien");
        Book book12 = new Book(12, "1984", "George Orwell");
        Book book13 = new Book(13, "To Kill a Mockingbird", "Harper Lee");
        Book book14 = new Book(14, "Catch-22", "Joseph Heller");
        Book book15 = new Book(15, "Divergent", "Veronica Roth");
        
        
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        library.addBook(book7);
        library.addBook(book8);
        library.addBook(book9);
        library.addBook(book10);
        library.addBook(book11);
        library.addBook(book12);
        library.addBook(book13);
        library.addBook(book14);
        library.addBook(book15);
        
        // ******* For testing purposes: Remove before submission ********
        Account account1 = new Account(new Members("Bob Smith", "123 E Sample Street", "3171234567"), 1);
        Account account2 = new Account(new Members("Joe Brown", "100 Apple Ln", "123-456-7890"), 2);
        library.addAccount(account1);
        library.addAccount(account2);
        
        int choice;
        
        
        while (!quit) {
            printMenu();
            System.out.println("Enter your choice");
            choice = scan.nextInt();
            performAction(choice);
        }
        System.out.println("Goodbye!");
        
    }

}
