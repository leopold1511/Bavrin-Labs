package SubPackage;

import Customer.Customer;
import Customer.CustomerFactory;
import Literature.Book;
import LiteratureFactory.EducationalBookFactory;
import LiteratureFactory.FictionBookFactory;

import java.util.*;

public class Generator {
    static EducationalBookFactory educationalBookFactory = new EducationalBookFactory();
    static FictionBookFactory fictionBookFactory = new FictionBookFactory();

    static Set<Book> makeSetOfBooks() {
        Set<Book> books = new HashSet<>();
        Random r = new Random();
        for (int i = 0; i < 120; i++) {
            switch (r.nextInt(4)) {
                case 0:
                    books.add(educationalBookFactory.createRuBook());
                    break;
                case 1:
                    books.add(educationalBookFactory.createEngBook());
                    break;
                case 2:
                    books.add(fictionBookFactory.createRuBook());
                    break;
                default:
                    books.add(fictionBookFactory.createEngBook());
                    break;
            }
        }
        return books;
    }

    static List<Customer> makeListOfCustomers(int numberOfCustomers) {
        List<Customer> customers = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < numberOfCustomers; i++) {
            if (r.nextBoolean()) {
                customers.add(CustomerFactory.createCustomer("Professor"));
            } else customers.add(CustomerFactory.createCustomer("Student"));
        }
        return customers;
    }

    public static CustomerInfo[] makeCustomersInfo(int numberOfCustomers) {
        Set<Book> books = makeSetOfBooks();
        List<Customer> customers = makeListOfCustomers(numberOfCustomers);
        CustomerInfo[] customerInfos = new CustomerInfo[numberOfCustomers];
        Random r = new Random();
        for (int i = 0; i < numberOfCustomers; i++) {
            int numberOfBooks = r.nextInt(3, 11);
            customerInfos[i] = new CustomerInfo("", new String[numberOfBooks]);
            customerInfos[i].customer = customers.get(i).getString();
            List<Integer> forCheckingRepeats = new ArrayList<>();
            for (int j = 0; j < numberOfBooks; j++) {
                int size = books.size();
                int item;
                do {
                    item = new Random().nextInt(size);
                } while (forCheckingRepeats.contains(item));
                forCheckingRepeats.add(item);
                int k = 0;
                for (Book obj : books) {
                    if (k == item) {
                        customerInfos[i].books[j] = obj.getString();
                        break;
                    }
                    k++;
                }

            }
        }
        return customerInfos;
    }
}
