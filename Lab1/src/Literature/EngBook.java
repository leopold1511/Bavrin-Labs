package Literature;

public abstract class EngBook implements Book {
    protected String author;
    protected int year;

    public EngBook(String author, int year) {
        this.author = author;
        this.year = year;
    }

}
