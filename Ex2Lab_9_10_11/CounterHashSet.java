package ExTema.Ex2Lab_9_10_11;

import java.util.*;

public class CounterHashSet extends HashSet<Integer> {

    //a)
    private int totalAdded;

    @Override
    public boolean add(Integer e) {
        boolean added = super.add(e);
        if (added) {
            totalAdded++;
        }
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        boolean changed = false;
        for (Integer v : c) {
            changed |= add(v);
        }
        return changed;
    }

    public int getTotalAdded() {
        return totalAdded;
    }
}
