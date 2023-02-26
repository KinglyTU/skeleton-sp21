package deque;

public class test {
    public static void main(String[] args) {
        int nextFirst = 17;
        int size = 16;
        if (nextFirst == 0){
            nextFirst =  size-1;
        } else {
            nextFirst = (nextFirst - 1) % size;
        }
        System.out.println(nextFirst);
    }
}
