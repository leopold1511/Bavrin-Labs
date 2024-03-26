package Literature;

public abstract class RuBook implements Book{
    protected String type;
    protected int edition;

    public RuBook(String type, int edition) {
        this.type = type;
        this.edition = edition;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }
}
