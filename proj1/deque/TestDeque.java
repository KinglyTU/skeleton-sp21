package deque;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestDeque {
    // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        ArrayDeque<Integer> correct = new ArrayDeque<>();
        LinkedListDeque<Integer> broken = new LinkedListDeque<>();

        correct.addLast(5);
        correct.addLast(10);
        correct.addLast(15);

        broken.addLast(5);
        broken.addLast(10);
        broken.addLast(15);

        assertEquals(correct.size(), broken.size());

        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
    }

    @Test
    public void randomizedTest() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        LinkedListDeque<Integer> broken = new LinkedListDeque<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                broken.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int brokenSize = broken.size();
                assertEquals(size, brokenSize);
//            } else if (operationNumber == 2 && L.size() != 0) {
//                int last = L.getLast();
//                int brokenLast = broken.getLast();
//                assertEquals(last, brokenLast);

            } else if (operationNumber == 3 && L.size() != 0) {
                L.removeLast();
                broken.removeLast();

            }
        }
    }


}

