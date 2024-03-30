package SubPackage;

import Customer.Customer;
import Customer.CustomerFactory;
import Literature.EngBook;
import Literature.RuBook;
import LiteratureFactory.EducationalBookFactory;
import LiteratureFactory.FictionBookFactory;

import java.util.*;

public class Generator {
    private static final Random random = new Random();

    private static Set<EngBook> makeSetOfEngBooks() {
        Set<EngBook> books = new HashSet<>();
        for (int i = 0; i < 60; i++) {
            books.add(random.nextBoolean() ? EducationalBookFactory.getInstance().createEngBook() :
                    FictionBookFactory.getInstance().createEngBook());
        }
        return books;
    }

    private static Set<RuBook> makeSetOfRuBooks() {
        Set<RuBook> books = new HashSet<>();
        for (int i = 0; i < 60; i++) {
            books.add(random.nextBoolean() ? FictionBookFactory.getInstance().createRuBook() :
                    EducationalBookFactory.getInstance().createRuBook());
        }
        return books;
    }

    private static List<Customer> makeListOfCustomers(int numberOfCustomers) {
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < numberOfCustomers; i++) {
            customers.add(random.nextBoolean() ? CustomerFactory.getInstance().createCustomer("Professor") :
                    CustomerFactory.getInstance().createCustomer("Student"));
        }
        return customers;
    }

    public static Customer[] generateCustomers(int numberOfCustomers) {
        List<Customer> listOfCustomers = makeListOfCustomers(numberOfCustomers);
        Customer[] customers = new Customer[numberOfCustomers];
        for (int i = 0; i < numberOfCustomers; i++) {
            customers[i] = listOfCustomers.get(i);
        }
        distributeBooks(customers);
        return customers;
    }

    private static void distributeBooks(Customer[] customers) {
        List<EngBook> engBooks = new ArrayList<>(makeSetOfEngBooks());
        List<RuBook> ruBooks = new ArrayList<>(makeSetOfRuBooks());
        for (Customer customer : customers) {
            int numberOfBooks = random.nextInt(3, 11);
            int item;
            for (int j = 0; j < numberOfBooks; j++) {
                if (random.nextBoolean()) {
                    do {
                        item = random.nextInt(engBooks.size());
                    } while (customer.isEngBookInList(engBooks.get(item)));
                    customer.englishBooks.add(engBooks.get(item));
                } else {
                    do {
                        item = random.nextInt(ruBooks.size());
                    } while (customer.isRuBookInList(ruBooks.get(item)));
                    customer.russianBooks.add(ruBooks.get(item));
                }
            }
        }
    }

}
