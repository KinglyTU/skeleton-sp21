package deque;

public class ArrayDeque<T> {
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

    public void addFirst(T item) {
        items[nextFirst] = item;
        if (nextFirst == 0) {
            nextFirst = capacity - 1;
        } else {
            nextFirst = (nextFirst - 1) % capacity;
        }
        size++;
    }

    public void addLast(T item) {
        items[nextLast] = item;
        nextLast = (nextLast + 1) % capacity;
        size++;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return size;
    }

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

    public T removeFirst() {
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
        size--;
        return temp;
    }

    public T removeLast() {
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
        size--;
        return temp;
    }

    public T get(int index) {
        if (index >= size || size == 0) {
            return null;
        }
        return items[(nextFirst + 1 + index) % capacity];
    }


}



