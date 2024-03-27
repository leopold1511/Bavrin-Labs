package Literature;

public abstract class RuBook implements Book {
    protected String type;
    protected int edition;

    public RuBook(String type, int edition) {
        this.type = type;
        this.edition = edition;
    }

}
