package ExTema.Ex1Lab_9_10_11;

import java.util.*;

//e)
public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog(Comparator.reverseOrder());

        catalog.add(new Student("Ana", 9.35f));
        catalog.add(new Student("Bogdan", 8.10f));
        catalog.add(new Student("Cristina", 7.40f));
        catalog.add(new Student("Dan", 7.55f));
        catalog.add(new Student("Elena", 9.80f));
        catalog.add(new Student("Florin", 8.49f));

        for (Map.Entry<Integer, List<Student>> entry : catalog.entrySet()) {
            List<Student> lista = entry.getValue();
            lista.sort(Comparator.comparing(Student::getNume));
            System.out.println("Nota " + entry.getKey() + ":");
            for (Student s : lista) {
                System.out.println("  " + s.getNume() + " (" + s.getMedie() + ")");
            }
        }
    }
}
