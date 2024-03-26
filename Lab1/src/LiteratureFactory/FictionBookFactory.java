package LiteratureFactory;

import Literature.Book;
import Literature.Fiction.FictionEngBook;
import Literature.Fiction.FictionRuBook;

import java.util.List;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class FictionBookFactory implements AbstractBookFactory {

    @Override
    public Book createRuBook(List<String[]> literatureList) {
        new FictionRuBook(null, 0, null, null);
        Random r = new Random();
        String[] bookInfo = literatureList.get(r.nextInt(literatureList.size() - 1));
        return new FictionRuBook(bookInfo[0], r.nextInt(3) + 1, bookInfo[1], bookInfo[2]);
    }

    @Override
    public Book createEngBook(List<String[]> literatureList) {
        new FictionEngBook(null, 0, null, null);
        Random r = new Random();
        String[] levels = {
                "A1", "A2", "B1", "B2", "C1", "C2"
        };
        String level = levels[r.nextInt(levels.length - 1)];
        String[] bookInfo = literatureList.get(r.nextInt(literatureList.size() - 1));
        return new FictionEngBook(bookInfo[0], parseInt(bookInfo[2]), bookInfo[1], level);
    }
}
