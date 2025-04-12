package Ex2;
import Ex1.*;

public class StackContainer extends AbstractContainer {

    public StackContainer() {
        super();
    }

    public StackContainer(int capacity) {
        super(capacity);
    }

    @Override
    public Task remove() {
        if (isEmpty()) {
            return null;
        }
        size--;
        return tasks[size];
    }
}
