import java.util.*;
public class LibrarySystem 
{
  // Encapsulation: Data of Book class(title,author,isIssued)is private
  static class Book
  {
   private String title;
   private String author;
   private boolean isIssued;

   // Constructor(used to intinlize object)
   public Book(String title, String author)

   {
    this.title=title;
    this.author=author;
    this.isIssued=false;
   }
   public String getTitle()
   {
    return title;
   }
   public boolean isIssued()
   {
    return isIssued;
   }
   public void issueBook()
   {
    isIssued=true;
   }
   public void returnBook()
   {
    isIssued=false;
   }
   public void displayInfo()
   {
    System.out.print("\nTitle: "+title+"\nAuthor: "+author+"\nIssued:"+isIssued);

   }
  } 
  // Abstraction: User class only hanlde to user rleted data
  static class User
  {
    private String name;
    private int userId;
    public User(String name,int userId)
    {
      this.name=name;
      this.userId=userId;
    }
    public String getName()
    {
      return name;
    }
    public int getUserId()
    {
      return userId;
    }
    public void displayUser()
    {
      System.out.print("\nUser ID: "+userId+"\nName: "+name);
    }
  } 
  // Abstraction & Composition: Library class manages list of Book(HAS-A rerlationship)
  static class Library
  {
    private List<Book> books= new ArrayList<>();//HAS-A relationship
    public void addBook(Book book)
    {
      books.add(book);

    }
    public void showAllBooks()
    {
      for(Book b:books)
      {
        b.displayInfo();
      }
    }
    // Polymorphism(Method Overriding idea):Same method name issueBook, but different user per object.

    public void issueBook(String title)
    {
      for(Book b:books)
      {
        if(b.getTitle().equalsIgnoreCase(title) && !b.isIssued())
        {
          b.issueBook();//calls Book's issueBook()
          System.out.println("Book issued successfully.");
          return;
        }
      }
      System.out.println("Book not available or already issued.");

    }
    public void returnBook(String title)
    {
      for(Book b:books)
      {
        if(b.getTitle().equalsIgnoreCase(title) &&b.isIssued())
        {
          b.returnBook();//call Book's returnBook()
          System.out.println("Book returned successfully.");
          return;
        }
      }
      System.out.println("Book was not issued.");

    }
  }
  //Main method: Program execution starts here
  public static void main(String args[])
  {
    Scanner sc=new Scanner(System.in); //take user inputs
    Library lib= new Library(); // Library object created 
    // object creation
    lib.addBook(new Book("java Basics","james Gosling"));
    lib.addBook(new Book("OOP Concept","Grady Booch"));
    System.out.println("Welcome To Library ManageMent System!");

    while(true)
    {
      System.out.println("\n1.Show Books\n2.Issue Book\n3.Return Book\n4.Exit");
      System.out.println("Choose an option:");
      int choice=sc.nextInt();
      sc.nextLine(); //consume newline

      switch(choice)
      {
        case 1:
        lib.showAllBooks();//show all books
        break;
        case 2:
        System.out.print("Enter book title to issue:");
        String issueTitle=sc.nextLine();
        lib.issueBook(issueTitle);// Issue book by title
        break;
        case 3:
        System.out.println("Enter book title to return:");
        String returnTitle=sc.nextLine();
        lib.returnBook(returnTitle);//Return book by title
        break;
        case 4:
        System.out.println("Thank you for using Library System.");
        return;
        default:
        System.out.println("Invalid choice.");
      }
    }
  }
}
