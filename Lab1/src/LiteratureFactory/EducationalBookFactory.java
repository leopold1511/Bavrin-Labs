package LiteratureFactory;

import Literature.Book;
import Literature.Educational.EducationalEngBook;
import Literature.Educational.EducationalRuBook;

import java.util.List;
import java.util.Random;

public class EducationalBookFactory implements AbstractBookFactory {
    @Override
    public Book createRuBook(List<String[]> disciplinesList) {
        String[] types = {
                "Задачник", "Учебник", "Пособие"
        };
        Random r = new Random();
        String type = types[r.nextInt(types.length - 1)];
        int edition = r.nextInt(3) + 1;
        return new EducationalRuBook(type, edition, disciplinesList.get(3)[r.nextInt(disciplinesList.get(3).length - 1)]);
    }

    @Override
    public Book createEngBook(List<String[]> disciplinesList) {
        Random r = new Random();
        boolean isBachelor = r.nextBoolean();
        int year = r.nextInt(1950, 2024);
        String author, university, discipline;
        discipline = disciplinesList.get(0)[r.nextInt(disciplinesList.get(0).length - 1)];
        author = disciplinesList.get(1)[r.nextInt(disciplinesList.get(1).length - 1)];
        university = disciplinesList.get(2)[r.nextInt(disciplinesList.get(2).length - 1)];
        return new EducationalEngBook(author, year, discipline, university, isBachelor);
    }
}

