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
            books.add(random.nextBoolean() ? EducationalBookFactory.getInstance().createEngBook() : FictionBookFactory.getInstance().createEngBook());
        }
        return books;
    }

    private static Set<RuBook> makeSetOfRuBooks() {
        Set<RuBook> books = new HashSet<>();
        for (int i = 0; i < 60; i++) {
            books.add(random.nextBoolean() ? FictionBookFactory.getInstance().createRuBook() : EducationalBookFactory.getInstance().createRuBook());
        }
        return books;
    }

    public static List<Customer> generateCustomers(int numberOfCustomers) {
        CustomerFactory customerFactory = new CustomerFactory();
        List<Customer> listOfCustomers = new ArrayList<>();
        for (int i = 0; i < numberOfCustomers; i++) {
            listOfCustomers.add(random.nextBoolean() ? customerFactory.createCustomer("Professor") : customerFactory.createCustomer("Student"));
        }
        giveOutBooks(listOfCustomers);
        return listOfCustomers;
    }

    private static void giveOutBooks(List<Customer> listOfCustomers) {
        List<EngBook> engBooks = new ArrayList<>(makeSetOfEngBooks());
        List<RuBook> ruBooks = new ArrayList<>(makeSetOfRuBooks());
        for (Customer customer : listOfCustomers) {
            int numberOfBooks = random.nextInt(3, 11);
            int numberOfRuBooks = random.nextInt(numberOfBooks);
            distributeBooks(numberOfBooks - numberOfRuBooks, engBooks, customer.englishBooks);
            distributeBooks(numberOfRuBooks, ruBooks, customer.russianBooks);
        }
    }

    private static <T> void distributeBooks(int numberOfBooks, List<T> allBooks, List<T> customerBooks) {
        for (int i = 0; i < numberOfBooks; i++) {
            List<Integer> repeats = new ArrayList<>();
            int item = random.nextInt(allBooks.size());
            do {
                customerBooks.add(allBooks.get(item));
                repeats.add(item);
            } while (!repeats.contains(item));
        }
    }
}
