package LiteratureFactory;

import Literature.Book;

interface AbstractBookFactory {
    Book createRuBook();

    Book createEngBook();
}
