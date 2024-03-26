package Literature.Fiction;

import Literature.RuBook;

public class FictionRuBook extends RuBook {
    private String title;
    private String author;

    public FictionRuBook(String type, int edition, String title, String author) {
        super(type, edition);
        this.title = title;
        this.author = author;
    }

    @Override
    public String getString() {
        return String.join(" ",type,"'",title,"'", author, edition+"-е","издание");
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
}
