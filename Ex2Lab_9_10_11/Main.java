package ExTema.Ex2Lab_9_10_11;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //b)
        /*
        In HashSet totalAdded depaseste size cand intra duplicate.
        Contorul trebuie marit doar daca super.add intoarce true,iar addAll sa invoce add pentru fiecare element
         */
        CounterHashSet set = new CounterHashSet();
        set.add(1);
        set.add(2);
        set.add(2);
        set.addAll(Arrays.asList(2, 3, 4, 4));
        System.out.println("HashSet size = " + set.size());
        System.out.println("HashSet totalAdded = " + set.getTotalAdded());
       /*
       In LinkedList size si totalAdded raman egale deoarece se accepta duplicate.
       Lista pastreaza ordinea inserarii,dar cautarea este liniara.
       */
        CounterList list = new CounterList();
        list.add(1);
        list.add(2);
        list.add(2);
        list.addAll(Arrays.asList(2, 3, 4, 4));
        System.out.println("List size = " + list.size());
        System.out.println("List totalAdded = " + list.getTotalAdded());
    }
}
