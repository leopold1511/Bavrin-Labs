package Literature.Educational;

import Literature.EngBook;

public class EducationalEngBook extends EngBook {
    private String discipline;
    private String university;
    private boolean isBachelor;

    public EducationalEngBook(String author, int year, String discipline, String university, boolean isBachelor) {
        super(author, year);
        this.discipline = discipline;
        this.university = university;
        this.isBachelor = isBachelor;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public boolean isBachelor() {
        return isBachelor;
    }

    public void setBachelor(boolean bachelor) {
        isBachelor = bachelor;
    }

    @Override
    public String getString() {
        if(isBachelor) return String.join(" ",discipline,author,university,"бакалавриат", year + "г" );
        return String.join(" ",discipline,author,university,"магистратура", year + "г" );
    }
}
