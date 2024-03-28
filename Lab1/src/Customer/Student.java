package Customer;

public class Student extends Customer {
    public Student(String name, String surname) {
        super(name, surname);
    }

    @Override
    public boolean isProfessor() {
        return false;
    }
}
