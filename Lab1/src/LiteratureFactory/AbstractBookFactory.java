package LiteratureFactory;

import Literature.Book;

import java.util.List;

interface AbstractBookFactory {
    Book createRuBook(List<String[]> list1);

    Book createEngBook(List<String[]> list2);
}
