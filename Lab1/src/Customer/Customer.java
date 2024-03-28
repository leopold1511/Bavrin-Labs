package Customer;

public abstract class Customer {
    protected String name;
    protected String surname;

    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getString() {
        return name + " " + surname;
    }

    public abstract boolean isProfessor();
}
