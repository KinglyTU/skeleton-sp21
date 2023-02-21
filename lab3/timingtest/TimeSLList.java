package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
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
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        SLList<Integer> integerSLList = new SLList<>();
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        timeGetLastHelper(1000,integerSLList,Ns,times,opCounts);
        timeGetLastHelper(2000,integerSLList,Ns,times,opCounts);
        timeGetLastHelper(4000,integerSLList,Ns,times,opCounts);
        timeGetLastHelper(8000,integerSLList,Ns,times,opCounts);
        timeGetLastHelper(16000,integerSLList,Ns,times,opCounts);
        timeGetLastHelper(32000,integerSLList,Ns,times,opCounts);
        timeGetLastHelper(64000,integerSLList,Ns,times,opCounts);
//        timeGetLastHelper(128000,integerSLList,Ns,times,opCounts);

        printTimingTable(Ns, times, opCounts);


    }

    public static void addItems(int N, SLList list) {
        for (int i = 0; i < N; i++) {
            list.addLast(N);
        }
    }

    public static double timeTestSList(int n, SLList list){
        addItems(n, list);
        Stopwatch sw = new Stopwatch();
        int M = 10000;
        for (int i = 0; i < M; i++) {
            list.getLast();
        }
        double timeInSeconds = sw.elapsedTime();
        return timeInSeconds;
    }

    public static void timeGetLastHelper(int n, SLList list, AList Ns, AList times, AList opCounts){
        double timeInSecond = timeTestSList(n, list);
        addItems(n,list);
        Ns.addLast(n);
        times.addLast(timeInSecond);
        opCounts.addLast(10000);
    }

}
