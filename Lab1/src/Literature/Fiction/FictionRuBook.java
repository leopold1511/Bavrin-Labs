package Literature.Fiction;

import Literature.RuBook;

public class FictionRuBook extends RuBook {
    private final String title;
    private final String author;

    public FictionRuBook(String type, int edition, String title, String author) {
        super(type, edition);
        this.title = title;
        this.author = author;
    }

    @Override
    public String getString() {
        return String.join(" ", type, "'", title, "'", author, edition + "-е", "издание");
    }

}
