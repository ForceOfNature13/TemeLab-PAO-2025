package Ex2;
import Ex1.Task;

public class QueueContainer extends AbstractContainer {

    public QueueContainer() {
        super();
    }

    public QueueContainer(int capacity) {
        super(capacity);
    }

    @Override
    public Task remove() {
        if (isEmpty()) {
            return null;
        }

        Task taskToRemove = tasks[0];

        for (int i = 1; i < size; i++) {
            tasks[i - 1] = tasks[i];
        }
        size--;
        tasks[size] = null;
        return taskToRemove;
    }
}
