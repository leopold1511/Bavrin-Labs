package EducationaLiterature;

public abstract class EducationalBook {
    String discipline;

    public EducationalBook(String discipline) {
        this.discipline = discipline;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
    public abstract String getString();
}
