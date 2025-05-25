package ExTema.Ex1Lab_9_10_11;

import java.util.*;

public class Catalog extends TreeMap<Integer, List<Student>> {
    //c)
    public Catalog(Comparator<Integer> comparator) {
        super(comparator);
    }

    private int rotunjeste(float medie) {
        return Math.round(medie);
    }
    //d)
    public void add(Student student) {
        int cheie = rotunjeste(student.getMedie());
        //a)
        if (cheie < 0 || cheie > 10) {
            throw new IllegalArgumentException("Medie in afara intervalului 0-10");
        }
        //b)
        computeIfAbsent(cheie, k -> new ArrayList<>()).add(student);
    }
}
