package Ex1;

import java.util.Random;

public class RandomOutTask implements Task {
    private final int randomNumber;

    public RandomOutTask() {

        Random rand = new Random();
        this.randomNumber = rand.nextInt(256);
    }

    @Override
    public void execute() {
        System.out.println("[RandomOutTask] The random number is: " + randomNumber);
    }
}
