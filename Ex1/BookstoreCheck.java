package Ex1;
public class BookstoreCheck {
    //c)
    public static boolean checkDuplicate(Book book, Book[] books) {
        int count = 0;
        for (Book b : books) {
            if (b.getTitle().equals(book.getTitle()) && b.getAuthor().equals(book.getAuthor()) && b.getPublisher().equals(book.getPublisher()) && b.getPageCount() == book.getPageCount()) {
                count++;
                if (count >= 2) {
                    return true;
                }
            }
        }
        return false;
    }
    public static Book getThickerBook(Book book1, Book book2) {
        if (book1.getPageCount() > book2.getPageCount()) {
            System.out.println("The book with the most pages is: \n" + book1);
            return book1;
        } else if(book1.getPageCount()<book2.getPageCount()) {
            System.out.println("The book with the most pages is: \n" + book2);
            return book2;
        }else{
            System.out.println("The books have the same number of pages");
            return null;
        }
    }

}
