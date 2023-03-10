package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {

    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        comparator = c;

    }

    public T max() {
        if (isEmpty()) {
            return null;
        }
        T max = get(0);
        for (int i = 0; i < size(); i++) {
            T current = get(i);
            if (comparator.compare(current, max) > 0) {
                max = current;
            }
        }
        return max;
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        T max = get(0);
        for (int i = 0; i < size(); i++) {
            T current = get(i);
            if (c.compare(current, max) > 0) {
                max = current;
            }
        }
        return max;
    }
}
