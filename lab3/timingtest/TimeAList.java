package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> integerAList = new AList<>();
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        printHelper(1000, integerAList, Ns, times, opCounts);
        printHelper(2000, integerAList, Ns, times, opCounts);
        printHelper(4000, integerAList, Ns, times, opCounts);
        printHelper(8000, integerAList, Ns, times, opCounts);
        printHelper(16000, integerAList, Ns, times, opCounts);
        printHelper(32000, integerAList, Ns, times, opCounts);
        printHelper(64000, integerAList, Ns, times, opCounts);
        printHelper(128000, integerAList, Ns, times, opCounts);

        printTimingTable(Ns, times, opCounts);


    }

    public static double timeTestAList(AList alist, int N) {
        Stopwatch sw = new Stopwatch();
        for (int i = 0; i < N; i++) {
            alist.addLast(i);
        }
        double timeInSeconds = sw.elapsedTime();
        return timeInSeconds;
    }

    public static void printHelper(int n, AList alist, AList Ns, AList times, AList opCounts) {
        double timeInSecond = timeTestAList(alist, n);
        Ns.addLast(n);
        times.addLast(timeInSecond);
        opCounts.addLast(n);
    }
}
