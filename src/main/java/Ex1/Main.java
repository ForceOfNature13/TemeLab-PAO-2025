package Ex1;
/*
1. Implementaţi si testati interfaţa Task în cele 3 moduri de mai jos:

a. Un task care să afișeze un mesaj la output. Mesajul este specificat în constructor. (OutTask.java)
b. Un task care generează un număr aleator și afișează un mesaj cu numărul generat la output. Generarea se face în constructor. (RandomOutTask.java)
c. Un task care incrementează un contor global și afișează valoarea contorului după fiecare incrementare (CounterOutTask.java).

 */

public class Main {
    public static void main(String[] args) {

        Task outTask = new OutTask("Greetings from OutTask!");

        outTask.execute();
        outTask.execute();

        Task randomOutTask = new RandomOutTask();
        randomOutTask.execute();

        randomOutTask.execute();

        Task counterOutTask1 = new CounterOutTask();
        Task counterOutTask2 = new CounterOutTask();

        counterOutTask1.execute();
        counterOutTask1.execute();
        counterOutTask2.execute();
        counterOutTask2.execute();
        counterOutTask1.execute();
    }
}
