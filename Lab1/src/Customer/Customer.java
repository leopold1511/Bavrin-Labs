package Customer;

import Literature.EngBook;
import Literature.RuBook;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.List;

public abstract class Customer {
    protected String name;
    protected String surname;
    public List<EngBook> englishBooks;
    public List<RuBook> russianBooks;


    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
        englishBooks = new ArrayList<>();
        russianBooks = new ArrayList<>();
    }

    public boolean isEngBookInList(Object newBook) {
        for (EngBook englishBook : englishBooks) {
            if (newBook.equals(englishBook)) return true;
        }
        return false;
    }

    public boolean isRuBookInList(RuBook newBook) {
        for (RuBook russianBook : russianBooks) {
            if (newBook.equals(russianBook)) return true;
        }
        return false;
    }

    public DefaultMutableTreeNode createNode() {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(getString());
        for (EngBook englishBook : englishBooks) {
            node.add(new DefaultMutableTreeNode(englishBook.getString()));
        }
        for (RuBook russianBook : russianBooks) {
            node.add(new DefaultMutableTreeNode(russianBook.getString()));
        }
        return node;
    }


    public abstract String getString();

    public abstract boolean isProfessor();
}
