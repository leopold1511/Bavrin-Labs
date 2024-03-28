package LiteratureFactory;

import Literature.EngBook;
import Literature.RuBook;

interface AbstractBookFactory {
    RuBook createRuBook();

    EngBook createEngBook();
}
