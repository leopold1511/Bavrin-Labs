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

    public boolean isEngBookInList(EngBook newBook) {
        for (EngBook englishBook : englishBooks) {
            if (newBook.equals(englishBook)) return true;
        }
        return false;
    }

    public boolean isRuBookInList(RuBook newBook) {
        for (int i = 0; i < russianBooks.size(); i++) {
            if (newBook.equals(russianBooks.get(i))) return true;
        }
        return false;
    }

    public void addBooksToNode(DefaultMutableTreeNode customerNode) {
        for (EngBook englishBook : englishBooks) {
            customerNode.add(new DefaultMutableTreeNode(englishBook.getString()));
        }
        for (RuBook russianBook : russianBooks) {
            customerNode.add(new DefaultMutableTreeNode(russianBook.getString()));
        }
    }


    public String getString() {
        return name + " " + surname;
    }

    public abstract boolean isProfessor();
}
