package EducationaLiterature;

public class RuEducationalBook extends EducationalBook {
    String type;

    public RuEducationalBook(String discipline, String type) {
        super(discipline);
        this.type = type;
    }

    @Override
    public String getString() {
        return String.join(" ", type, discipline);
    }
}
