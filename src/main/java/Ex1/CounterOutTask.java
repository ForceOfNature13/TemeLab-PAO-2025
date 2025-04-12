package Ex1;
public class CounterOutTask implements Task {
    private static int counter = 0;

    @Override
    public void execute() {
        counter++;
        System.out.println("[CounterOutTask] Current counter value: " + counter);
    }
}

