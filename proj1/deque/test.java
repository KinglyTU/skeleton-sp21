package deque;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class test {
    public static void main(String[] args) {

        MaxArrayDeque<Integer> a = new MaxArrayDeque<Integer>(Comparator.naturalOrder());
        a.addLast(10);
        a.addLast(11);
        a.addLast(19);
        a.addLast(12);
        a.addLast(13);


        System.out.println(a.max());

    }

}

