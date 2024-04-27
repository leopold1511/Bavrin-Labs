package LiteratureFactory;

import Literature.EngBook;
import Literature.Fiction.FictionEngBook;
import Literature.Fiction.FictionRuBook;
import Literature.RuBook;
import SubPackage.MyCsvReader;

import java.util.List;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class FictionBookFactory implements AbstractBookFactory {
    private final List<String[]> englishFictionList;
    private final List<String[]> russianFictionList;

    public FictionBookFactory() {
        russianFictionList = MyCsvReader.readCsv("Lab1/data/russian_fiction.csv");
        englishFictionList = MyCsvReader.readCsv("Lab1/data/english_fiction.csv");
    }


    @Override
    public RuBook createRuBook() {
        new FictionRuBook(null, 0, null, null);
        Random r = new Random();
        String[] bookInfo = russianFictionList.get(r.nextInt(russianFictionList.size() - 1));
        return new FictionRuBook(bookInfo[0], r.nextInt(3) + 1, bookInfo[1], bookInfo[2]);
    }

    @Override
    public EngBook createEngBook() {
        new FictionEngBook(null, 0, null, null);
        Random r = new Random();
        String[] levels = {
                "A1", "A2", "B1", "B2", "C1", "C2"
        };
        String level = levels[r.nextInt(levels.length - 1)];
        String[] bookInfo = englishFictionList.get(r.nextInt(englishFictionList.size() - 1));
        return new FictionEngBook(bookInfo[0], parseInt(bookInfo[2]), bookInfo[1], level);
    }
}
