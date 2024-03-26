package EducationaLiterature;

public class EngEducationalBook extends EducationalBook {
    String level;
    String author;
    String university;

    public EngEducationalBook(String discipline, String level, String author, String university) {
        super(discipline);
        this.author = author;
        this.university = university;
        this.level = level;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String getString() {
        return String.join(" ", level, discipline, author, university);
    }
}
