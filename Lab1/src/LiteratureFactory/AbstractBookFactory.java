package LiteratureFactory;

import Literature.Book;

import java.util.List;

interface AbstractBookFactory {
    Book createRuBook();

    Book createEngBook();
}
