package CustomerFactory;

import Customer.Customer;

import java.util.List;

public interface CustomerFactory {
     Customer CreateCustomer(List<String[]> listOfNames, List<String[]> listOfSurnames);
}
