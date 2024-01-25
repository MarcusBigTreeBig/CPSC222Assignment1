/**
 * Creates 10 threads and runs them
 * The threads print out how many times each thread has run
 * The threads do not use locks to ensure they print correct values
 */
public class BasicThreadsMain {
    public static void main (String[] args) {
        int n = 10;
        CustomThreadNoLocks[] threads = new CustomThreadNoLocks[n];
        for (int i = 0; i < n; i++) {
            threads[i] = new CustomThreadNoLocks();
            threads[i].start();
        }
    }
}
/*
Some output:

Here the sum reported by thread 8 is smaller than the sum of thread 9 which printed it's results before it.
This means that thread 8 did not print with the corrected values for when each thread had run.

Thread ID: 9
Times Run:
0: 12244
1: 12963
2: 14379
3: 14160
4: 12177
5: 13468
6: 16395
7: 15014
8: 13711
9: 16173
Sum:140684

Thread ID: 8
Times Run:
0: 12244
1: 12963
2: 14379
3: 14158
4: 12169
5: 13468
6: 16395
7: 15014
8: 13711
9: 16166
Sum:140667
 */