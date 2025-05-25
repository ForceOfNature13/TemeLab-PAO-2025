package ExTema.Ex2Lab_9_10_11;

import java.util.*;

//b)

public class CounterList extends LinkedList<Integer> {
    private int totalAdded;

    @Override
    public boolean add(Integer e) {
        totalAdded++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        totalAdded += c.size();
        return super.addAll(c);
    }

    public int getTotalAdded() {
        return totalAdded;
    }
}
