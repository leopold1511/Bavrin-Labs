package Literature.Fiction;

import Literature.EngBook;

public class FictionEngBook extends EngBook {
    private String title;
    private String level;

    public FictionEngBook(String author, int year, String title, String level) {
        super(author, year);
        this.title = title;
        this.level = level;
    }

    @Override
    public String getString() {
        return String.join(" ",title,author,year+"г",level);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
