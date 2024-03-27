package Customer;

import SubPackage.MyCsvReader;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class CustomerFactory {
    static List<String[]> listOfNames = MyCsvReader.readCsv("data/names.csv");
    static List<String[]> listOfSurnames = MyCsvReader.readCsv("data/surnames.csv");
    static List<String[]> listOfProfessorSurnames = MyCsvReader.readCsv("data/professor_surnames.csv");

    static Customer createCustomer(String type) {
        return switch (type) {
            case "Professor" -> createProfessor(listOfNames, listOfProfessorSurnames);
            case "Student" -> createStudent(listOfNames, listOfSurnames);
            default -> null;
        };
    }

    static private Customer createProfessor(List<String[]> listOfNames, List<String[]> listOfSurnames) {
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

    static private boolean checkSurname(String surname) {
        return !surname.endsWith("о") && !surname.endsWith("ь");
    }

    static private Customer createStudent(List<String[]> listOfNames, List<String[]> listOfSurnames) {
        Random r = new Random();
        String[] name = listOfNames.get(r.nextInt(listOfNames.size() - 1));
        String surname = listOfSurnames.get(r.nextInt(listOfSurnames.size() - 1))[0];
        if (Objects.equals(name[1], "F")) surname = surname + "а";
        return new Student(name[0], surname);
    }


}
