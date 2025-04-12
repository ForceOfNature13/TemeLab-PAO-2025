package Ex2;
import Ex1.*;

public abstract class AbstractContainer implements Container {
    protected Task[] tasks;
    protected int size;
    private static final int DEFAULT_CAPACITY = 10;

    public AbstractContainer() {
        this(DEFAULT_CAPACITY);
    }

    public AbstractContainer(int capacity) {
        tasks = new Task[capacity];
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(Task task) {
        if (size == tasks.length) {
            resize();
        }
        tasks[size++] = task;
    }

    protected void resize() {
        Task[] newArray = new Task[tasks.length * 2];
        for (int i = 0; i < tasks.length; i++) {
            newArray[i] = tasks[i];
        }
        tasks = newArray;
    }
}
