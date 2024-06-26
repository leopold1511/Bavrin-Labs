package Customer;

public class Professor extends Customer {
    private final String patronymic;

    public Professor(String name, String patronymic, String surname) {
        super(name, surname);
        this.patronymic = patronymic;
    }

    public String getString() {
        return String.join(" ", name, patronymic, surname);
    }

    @Override
    public boolean isProfessor() {
        return true;
    }
}
