package Literature.Fiction;

import Literature.EngBook;

public class FictionEngBook extends EngBook {
    private final String title;
    private final String level;

    public FictionEngBook(String author, int year, String title, String level) {
        super(author, year);
        this.title = title;
        this.level = level;
    }

    @Override
    public String getString() {
        return String.join(" ",title,author,year+"г",level);
    }

}
