package LiteratureFactory;

import Literature.Book;
import Literature.Educational.EducationalEngBook;
import Literature.Educational.EducationalRuBook;
import SubPackage.MyCsvReader;

import java.util.List;
import java.util.Random;

public class EducationalBookFactory implements AbstractBookFactory {
    static List<String[]> disciplinesList = MyCsvReader.readCsv("Lab1/data/disciplines.csv");

    @Override
    public Book createRuBook() {
        String[] types = {
                "Задачник", "Учебник", "Пособие"
        };
        Random r = new Random();
        String type = types[r.nextInt(types.length - 1)];
        int edition = r.nextInt(3) + 1;
        return new EducationalRuBook(type, edition, disciplinesList.get(3)[r.nextInt(disciplinesList.get(3).length - 1)]);
    }


    public  Book createEngBook() {
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

