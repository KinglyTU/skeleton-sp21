package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int capacity;

    public ArrayDeque() {
        capacity = 8;
        items = (T[]) new Object[capacity];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public void resizeUp() {
        T[] itemsResized = (T[]) new Object[capacity * 2];
        items = copyArrayInOrder(itemsResized, items);
        capacity *= 2;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    public void resizeDown() {
        T[] itemsResized = (T[]) new Object[capacity / 2];
        items = copyArrayInOrder(itemsResized, items);
        capacity /= 2;
    }

    public T[] copyArrayInOrder(T[] itemsResized, T[] items) {
        int j = 0;
        for (int i = nextFirst + 1; i < size + nextFirst + 1; i++) {
            itemsResized[j] = items[i % capacity];
            j++;
        }
        return itemsResized;

    }

    @Override
    public void addFirst(T item) {
        if (size == capacity) {
            resizeUp();
        }
        items[nextFirst] = item;
        if (nextFirst == 0) {
            nextFirst = capacity - 1;
        } else {
            nextFirst = (nextFirst - 1) % capacity;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        if (size == capacity) {
            resizeUp();
        }
        if (size == 0) {
            addFirst(item);
        } else {
            items[nextLast] = item;
            nextLast = (nextLast + 1) % capacity;
            size++;
        }

    }

    /*    public boolean isEmpty() {
            if (size == 0) {
                return true;
            } else {
                return false;
            }
        }*/
    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        int count = 0;
        for (int i = nextFirst + 1; count < size; i++, count++) {
            if (i >= capacity) {
                i = i % capacity;
            }
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size <= capacity / 4 && capacity > 16) {
            resizeDown();
        }
        T temp;
        if (size == 0) {
            return null;
        }
        if ((nextFirst + 1) == capacity) {
            temp = items[0];
            items[0] = null;
        } else {
            temp = items[nextFirst + 1];
            items[nextFirst + 1] = null;
        }
        nextFirst++;
        if (nextFirst == capacity) {
            nextFirst = 0;
        }
        size--;
        return temp;
    }

    @Override
    public T removeLast() {
        if (size <= capacity / 4 && capacity > 16) {
            resizeDown();
        }
        T temp;
        if (size == 0) {
            return null;
        }

        if ((nextLast - 1) < 0) {
            temp = items[capacity - 1];
            items[capacity - 1] = null;
        } else {
            temp = items[nextLast - 1];
            items[nextLast - 1] = null;
        }
        nextLast--;
        if (nextLast < 0) {
            nextLast = capacity - 1;
        }
        size--;
        return temp;
    }

    @Override
    public T get(int index) {
        if (index >= size || size == 0) {
            return null;
        }
        return items[(nextFirst + 1 + index) % capacity];
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int wizPos;

        public ArrayDequeIterator() {
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            return wizPos < size;
        }

        public T next() {
            T returnItem = items[wizPos];
            wizPos++;
            return returnItem;
        }
    }


    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        ArrayDeque<T> o = (ArrayDeque<T>) other;
        if (o.size() != this.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (o.items[i].equals(this.items[i])) {
                continue;
            } else return false;
        }
        return true;


    }
}



