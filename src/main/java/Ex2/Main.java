package Ex2;
import Ex1.*;
/*
2. Interfaţa Container specifică interfaţa comună pentru colecţii de obiecte Task, în care se pot adăuga și din care se pot elimina elemente.
Creaţi si testati două tipuri de containere care implementează această interfata:

a. Stack - care implementează o strategie de tip LIFO
b. Queue - care implementează o strategie de tip FIFO

Evitaţi codul similar în locuri diferite si utilizati array-uri (nu API-ul de colectii).
 */
public class Main {
    public static void main(String[] args) {

        Task t1 = new OutTask("Task 1");
        Task t2 = new RandomOutTask();
        Task t3 = new CounterOutTask();
        Task t4 = new OutTask("Task 4");
        Task t5 = new RandomOutTask();


        Container stack = new StackContainer();
        stack.add(t1);
        stack.add(t2);
        stack.add(t3);
        stack.add(t4);
        stack.add(t5);

        System.out.println("Removing from Stack (LIFO):");
        while (!stack.isEmpty()) {
            Task removed = stack.remove();
            removed.execute();
        }


        Container queue = new QueueContainer();
        queue.add(t1);
        queue.add(t2);
        queue.add(t3);
        queue.add(t4);
        queue.add(t5);

        System.out.println("\nRemoving from Queue (FIFO):");
        while (!queue.isEmpty()) {
            Task removed = queue.remove();
            removed.execute();
        }
    }
}
