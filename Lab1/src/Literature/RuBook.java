package Literature;

public abstract class RuBook {
    protected String type;
    protected int edition;
    public abstract String getString();

    public RuBook(String type, int edition) {
        this.type = type;
        this.edition = edition;
    }

}
