package Literature.Educational;

import Literature.EngBook;

public class EducationalEngBook extends EngBook {
    private final String discipline;
    private final String university;
    private final boolean isBachelor;

    public EducationalEngBook(String author, int year, String discipline, String university, boolean isBachelor) {
        super(author, year);
        this.discipline = discipline;
        this.university = university;
        this.isBachelor = isBachelor;
    }

    @Override
    public String getString() {
        if(isBachelor) return String.join(" ",discipline,author,university,"бакалавриат", year + "г" );
        return String.join(" ",discipline,author,university,"магистратура", year + "г" );
    }
}
