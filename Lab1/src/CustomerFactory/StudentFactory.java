package CustomerFactory;

import Customer.Customer;
import Customer.Student;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class StudentFactory implements CustomerFactory {
    public Customer CreateCustomer(List<String[]> listOfNames, List<String[]> listOfSurnames) {
        Random r = new Random();
        String[] name = listOfNames.get(r.nextInt(listOfNames.size() - 1));
        String surname = listOfSurnames.get(r.nextInt(listOfSurnames.size() - 1))[0];
        if (Objects.equals(name[1], "F")) surname = surname + "а";
        Student customer = new Student(name[0], surname);
        return customer;
    }
}
