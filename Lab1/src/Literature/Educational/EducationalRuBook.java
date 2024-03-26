package Literature.Educational;

import Literature.RuBook;

public class EducationalRuBook extends RuBook {
    private final String discipline;

    public EducationalRuBook(String type, int edition, String discipline) {
        super(type, edition);
        this.discipline = discipline;
    }

    @Override
    public String getString() {
        return String.join(" ", type, discipline, edition + "-е издание");
    }
}
