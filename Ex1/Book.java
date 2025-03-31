package Ex1;

public class Book {
    //a)
    private String title;
    private String author;
    private String publisher;
    private int pageCount;

    public Book(){
        this.title = "No title";
        this.author = "No author";
        this.publisher = "No publisher";
        this.pageCount = 0;
    }
    public Book(String title, String author, String publisher, int pageCount) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pageCount = pageCount;
    }
    public String getTitle() {
        return this.title;
    }
    public String getAuthor() {
        return this.author;
    }
    public String getPublisher() {
        return this.publisher;
    }
    public int getPageCount() {
        return this.pageCount;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    //d)
    @Override
    public String toString(){
        return "BOOK_TITLE: "+this.title.toUpperCase()+"\nBOOK_AUTHOR: "+this.author.toLowerCase()+"\nBOOK_PUBLISHER: "+this.publisher+"\n";

    }
}
