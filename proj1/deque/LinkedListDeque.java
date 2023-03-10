package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    public class Node {
        private T item;
        private Node next;
        private Node prev;

        public Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;

        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        size = 0;
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    @Override
    public void addFirst(T item) {
        if (sentinel.next == sentinel) {
            sentinel.next = new Node(sentinel, item, sentinel);
            sentinel.prev = sentinel.next;
        } else {
            Node temp = sentinel.next;
            sentinel.next = new Node(sentinel, item, temp);
            temp.prev = sentinel.next;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        if (sentinel.prev == sentinel) {
            addFirst(item);
        } else {
            Node temp = sentinel.prev;
            temp.next = new Node(temp, item, sentinel);
            sentinel.prev = temp.next;
            size++;
        }

    }

    /*    public boolean isEmpty() {
            if (sentinel.next == sentinel) {
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
        Node temp = sentinel.next;
        while (temp != sentinel) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        } else {
            Node temp = sentinel.next;
            if (temp.next == sentinel) {
                sentinel.next = sentinel;
                sentinel.prev = sentinel;
            }
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size--;
            return temp.item;
        }
    }

    @Override
    public T removeLast() {
        if (sentinel.prev == sentinel) {
            return null;
        } else {
            Node temp = sentinel.prev;
            T lastItem = temp.item;
            temp.prev.next = sentinel;
            sentinel.prev = temp.prev;
            size--;
            return lastItem;
        }
    }

    @Override
    public T get(int index) {
        Node temp = sentinel;
        for (int i = 0; i <= index; i++) {
            if (temp.next == sentinel) {
                return null;
            } else {
                temp = temp.next;
            }
        }
        return temp.item;
    }

    public T getRecursive(int index) {
        return getRecursiveHelper(sentinel.next, index);
    }

    private T getRecursiveHelper(Node node, int index) {
        if (node == sentinel) {
            return null;
        } else if (index == 0) {
            return node.item;
        } else {
            return getRecursiveHelper(node.next, index - 1);
        }
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator {
        int wizPos;

        public LinkedListIterator() {
            wizPos = 1;
        }

        @Override
        public boolean hasNext() {
            return wizPos <= size;
        }

        @Override
        public T next() {
            if (wizPos == 1) {
                wizPos++;
                return sentinel.next.item;
            } else {
                return nextHelper(wizPos, sentinel).item;
            }
        }

        private Node nextHelper(int n, Node node) {
            while (n > 0) {
                node = node.next;
                n--;
            }
            wizPos++;
            return node;
        }


    }


}
