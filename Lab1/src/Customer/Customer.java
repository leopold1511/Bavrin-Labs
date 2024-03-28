package Customer;

import Literature.EngBook;

public abstract class Customer {
    protected String name;
    protected String surname;
    public EngBook[] englishBooks;
    public EngBook[] russianBooks;


    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getString() {
        return name + " " + surname;
    }

    public abstract boolean isProfessor();
}
