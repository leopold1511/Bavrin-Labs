package Customer;

import Literature.EngBook;
import Literature.RuBook;

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
        englishBooks=new ArrayList<>();
        russianBooks=new ArrayList<>();
    }

    public String getString() {
        return name + " " + surname;
    }

    public abstract boolean isProfessor();
}
