package CustomerFactory;

import Customer.*;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class ProfessorFactory implements CustomerFactory {
    public Customer CreateCustomer(List<String[]> listOfNames, List<String[]> listOfSurnames) {
        Random r = new Random();
        String[] name = listOfNames.get(r.nextInt(listOfNames.size() - 1));
        String surname = listOfSurnames.get(r.nextInt(listOfSurnames.size() - 1))[0];
        String[] nameForPatronymics;
        String patronymics;
        do {
            nameForPatronymics = listOfNames.get(r.nextInt(listOfNames.size() - 1));
        } while (Objects.equals(nameForPatronymics[1], "F"));
        if (Objects.equals(name[1], "F")) {
            if (checkSurname(surname)) surname = surname + "а";
            patronymics = nameForPatronymics[3];
        } else patronymics = nameForPatronymics[2];
        return new Professor(name[0], patronymics, surname);
    }

    private boolean checkSurname(String surname) {
        return !surname.endsWith("о") && !surname.endsWith("ь");
    }
}


