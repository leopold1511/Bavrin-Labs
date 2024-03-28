package Literature;

public abstract class EngBook {
    protected String author;
    protected int year;
    public abstract String getString();

    public EngBook(String author, int year) {
        this.author = author;
        this.year = year;
    }

}
