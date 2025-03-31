package Ex1;
import java.util.Scanner;
/*
a. Creați un proiect nou cu numele Bookstore si urmatoarele clase:
        - clasa Book cu următoarele atribute: title, author, publisher, pageCount.
- clasa BookstoreTest pentru a testa viitoarele funcționalități ale bibliotecii.
Completați această clasă cu metode CRUD (create, read, update, delete) pentru a simula functionalitatea.

b. Creați obiecte de tip carte și setați atributele introducând date de la tastatură.
Verificați ca numărul de pagini introdus să fie diferit de zero.

c. Creați o clasă nouă, BookstoreCheck, ce va conține două metode:
        - prima metodă va verifica dacă o carte este în dublu exemplar;
- a doua metodă va verifica daca o carte este mai groasă decât alta și va returna cartea mai groasă.
Testați aceste doua metode.

d. Afișați informația despre o carte în felul următor:
BOOK_TITLE: [insert_book_title]
BOOK_AUTHOR: [insert_book_author]
BOOK_PUBLISHER: [insert_book_publisher]
Cu următoarele precizări:
        - titlul cărții va fi scris în întregime cu majuscule;
- numele editurii va fi scris în întregime cu minuscule;
- numele autorului rămâne neschimbat.
*/
public class BookstoreTest {
    //a) CRUD
    private static Book [] books;

    //b)
    public static void create(Scanner scanner){

        System.out.print("Enter the Title:");
        String title=scanner.nextLine();

        System.out.print("Enter the Author:");
        String author=scanner.nextLine();

        System.out.print("Enter the Publisher:");
        String publisher=scanner.nextLine();

        int pageCount=0;

        while(pageCount==0){
            System.out.print("Enter the Page Count:");
            pageCount=Integer.parseInt(scanner.nextLine());

            if(pageCount<=0){
                System.out.println("The page count must be greater than 0");
                pageCount=0;
            }
        }

        Book book = new Book(title, author, publisher, pageCount);

        if(books!=null) {
            Book[] booksAux = new Book[books.length + 1];

            for (int i = 0; i < books.length; i++) {
                booksAux[i] = books[i];
            }
            booksAux[booksAux.length - 1] = book;

            books=booksAux;
        }else{
            books = new Book[1];
            books[0]=book;
        }

        System.out.println("Book added successfully!");

    }
    public static void read() {
        if (books == null || books.length == 0) {
            System.out.println("No books found");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
    public static void update(int id){
        if (books == null || books.length == 0) {
            System.out.println("No books found");
        } else {
            if (id >= 0 && id < books.length) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter the Title:");
                String title = scanner.nextLine();

                System.out.print("Enter the Author:");
                String author = scanner.nextLine();

                System.out.print("Enter the Publisher:");
                String publisher = scanner.nextLine();

                int pageCount = 0;

                while (pageCount == 0) {
                    System.out.print("Enter the Page Count:");
                    pageCount = Integer.parseInt(scanner.nextLine());

                    if (pageCount <= 0) {
                        System.out.println("The page count must be greater than 0");
                        pageCount = 0;
                    }
                }

                books[id].setTitle(title);
                books[id].setAuthor(author);
                books[id].setPublisher(publisher);
                books[id].setPageCount(pageCount);

                System.out.println("Book updated successfully!");
            } else {
                System.out.println("Invalid id");
            }
        }
    }

    public static void delete(int id){
        if (books == null || books.length == 0) {
            System.out.println("No books found");
        } else {
            if (id >= 0 && id < books.length) {
                Book[] booksAux = new Book[books.length - 1];
                int j = 0;
                for (int i = 0; i < books.length; i++) {
                    if (i != id) {
                        booksAux[j] = books[i];
                        j++;
                    }
                }
                books = booksAux;
                System.out.println("Book deleted successfully!");
            } else {
                System.out.println("Invalid id");
            }
        }
    }
    public static void search(int id) {
        if (books == null || books.length == 0) {
            System.out.println("No books found");
        } else {
            if (id >= 0 && id < books.length) {
                System.out.println(books[id]);
            } else {
                System.out.println("Invalid id");
            }
        }
    }


    public static void main(String[] args) {
           Scanner scanner = new Scanner(System.in);
           boolean ok=true;
           int option,id,id1,id2;

           while(ok) {
               System.out.println("-----Welcome to the Bookstore Menu-----:");
               System.out.println("1. Create");
               System.out.println("2. Read");
               System.out.println("3. Update");
               System.out.println("4. Delete");
               System.out.println("5. Search");
               System.out.println("6. Check Duplicate");
               System.out.println("7. Compare Books");
               System.out.println("8. Exit");
               System.out.println("Choose an option: ");

               option = Integer.parseInt(scanner.nextLine());

                switch(option) {
                    case 1:
                        create(scanner);
                        break;
                    case 2:
                        read();
                        break;
                    case 3:
                        System.out.print("Enter the id:");
                        id=Integer.parseInt(scanner.nextLine());

                        update(id);
                        break;
                    case 4:
                        System.out.println("Enter the id:");
                        id=Integer.parseInt(scanner.nextLine());

                        delete(id);
                        break;
                    case 5:
                        System.out.println("Enter the id:");
                        id=Integer.parseInt(scanner.nextLine());

                        search(id);
                        break;
                    case 6:
                        System.out.println("Enter the id of the book you want to check:");
                        id=Integer.parseInt(scanner.nextLine());
                        if(books!=null && books.length>1) {
                            if (BookstoreCheck.checkDuplicate(books[id], books)) {
                                System.out.println("The book is in duplicate");
                            } else {
                                System.out.println("The book is not in duplicate");
                            }
                        }else{
                            System.out.println("There are not enough books to check");
                        }
                        break;
                    case 7:
                        if(books!=null && books.length>1) {
                            System.out.println("Enter the id of the first book:");
                            id1=Integer.parseInt(scanner.nextLine());

                            if(id1>=0 && id1<books.length) {
                                System.out.println("Enter the id of the second book:");
                                id2 = Integer.parseInt(scanner.nextLine());

                                if (id2 >= 0 && id2 < books.length) {
                                    BookstoreCheck.getThickerBook(books[id1], books[id2]);
                                } else {
                                    System.out.println("Invalid id for the second book");
                                }
                            }else{
                                    System.out.println("Invalid id for the first book");
                                }
                            }else{
                                    System.out.println("There are not enough books to compare");
                                }
                        break;
                    case 8:
                        ok=false;
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
           }
    }
}
