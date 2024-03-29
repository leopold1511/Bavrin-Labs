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
        Set<EngBook> engBooks = makeSetOfEngBooks();
        Set<RuBook> ruBooks = makeSetOfRuBooks();
        Customer[] customers = new Customer[numberOfCustomers];
        List<Integer> forCustomerRepeats = new ArrayList<>();
        for (int i = 0; i < numberOfCustomers; i++) {
            int customerId;
            do {
                customerId = random.nextInt(listOfCustomers.size());
            } while (forCustomerRepeats.contains(customerId));
            customers[i] = listOfCustomers.get(customerId);
            forCustomerRepeats.add(customerId);
        }
        distributeBooks(customers, engBooks, ruBooks);
        return customers;
    }

    private static void distributeBooks(Customer[] customers, Set<EngBook> engBooks, Set<RuBook> ruBooks) {
        int engBookSize = engBooks.size();
        int ruBookSize = ruBooks.size();

        for (Customer customer : customers) {
            Set<Integer> forCheckingEngRepeats = new HashSet<>();
            Set<Integer> forCheckingRuRepeats = new HashSet<>();
            int numberOfBooks = random.nextInt(3, 11);

            for (int j = 0; j < numberOfBooks; j++) {
                if (random.nextBoolean()) {
                    addRandomBook(customer.englishBooks, engBooks, forCheckingEngRepeats, engBookSize);
                } else {
                    addRandomBook(customer.russianBooks, ruBooks, forCheckingRuRepeats, ruBookSize);
                }
            }
        }
    }

    private static <T> void addRandomBook(Collection<T> customerBooks, Collection<T> availableBooks, Set<Integer> forCheckingRepeats, int bookSize) {
        int item;
        do {
            item = random.nextInt(bookSize);
        } while (forCheckingRepeats.contains(item));

        int k = 0;
        for (T obj : availableBooks) {
            if (k == item) {
                customerBooks.add(obj);
                break;
            }
            k++;
        }
        forCheckingRepeats.add(item);
    }
}
