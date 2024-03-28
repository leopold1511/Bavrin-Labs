package SubPackage;

import Customer.Customer;
import Customer.CustomerFactory;
import Literature.EngBook;
import Literature.RuBook;
import LiteratureFactory.EducationalBookFactory;
import LiteratureFactory.FictionBookFactory;

import java.util.*;

public class Generator {

    static Set<EngBook> makeSetOfEngBooks() {
        Set<EngBook> books = new HashSet<>();
        Random r = new Random();
        for (int i = 0; i < 60; i++) {
            if (r.nextBoolean()) {
                books.add(EducationalBookFactory.getInstance().createEngBook());
            } else books.add(FictionBookFactory.getInstance().createEngBook());
        }
        return books;
    }

    static Set<RuBook> makeSetOfRuBooks() {
        Set<RuBook> books = new HashSet<>();
        Random r = new Random();
        for (int i = 0; i < 60; i++) {
            if (r.nextBoolean()) {
                books.add(FictionBookFactory.getInstance().createRuBook());
            } else books.add(EducationalBookFactory.getInstance().createRuBook());
        }
        return books;
    }


    static List<Customer> makeListOfCustomers(int numberOfCustomers) {
        List<Customer> customers = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < numberOfCustomers; i++) {
            if (r.nextBoolean()) {
                customers.add(CustomerFactory.getInstance().createCustomer("Professor"));
            } else customers.add(CustomerFactory.getInstance().createCustomer("Student"));
        }
        return customers;
    }

    public static CustomerInfo[] makeCustomersInfo(int numberOfCustomers) {
        Set<EngBook> engBooks = makeSetOfEngBooks();
        Set<RuBook> ruBooks = makeSetOfRuBooks();
        List<Customer> customers = makeListOfCustomers(numberOfCustomers);
        CustomerInfo[] customerInfos = new CustomerInfo[numberOfCustomers];
        Random r = new Random();
        for (int i = 0; i < numberOfCustomers; i++) {
            int numberOfBooks = r.nextInt(3, 11);
            if (customers.get(i).isProfessor()) {
                customerInfos[i] = new CustomerInfo("", new String[numberOfBooks], true);
            } else customerInfos[i] = new CustomerInfo("", new String[numberOfBooks], false);
            customerInfos[i].customer = customers.get(i).getString();

            List<Integer> forCheckingRepeats = new ArrayList<>();
            for (int j = 0; j < numberOfBooks; j++) {
                int size = engBooks.size();
                int item;
                do {
                    item = new Random().nextInt(size);
                } while (forCheckingRepeats.contains(item));
                forCheckingRepeats.add(item);
                int k = 0;
                for (EngBook obj : engBooks) {
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
