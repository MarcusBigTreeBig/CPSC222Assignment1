/**
 * Creates 10 Threads
 * These threads print how many times each thread has run
 * Threads use a non reentrant lock to ensure they run in order
 */
public class BasicLockMain {
    public static void main (String[] args) {
        int n = 10;
        CustomThreadBasicLock[] threads = new CustomThreadBasicLock[n];
        CustomBasicLock lock = new CustomBasicLock();
        for (int i = 0; i < n; i++) {
            threads[i] = new CustomThreadBasicLock(lock);
            threads[i].start();
        }
    }
}

/*
Some output:

Even when the thread changes, it's using all the right data.


Thread ID: 1
Times Run:
0: 21457
1: 18874
2: 23486
3: 23709
4: 24768
5: 21934
6: 21144
7: 23555
8: 23528
9: 20889
Sum:223344

Thread ID: 2
Times Run:
0: 21457
1: 18875
2: 23486
3: 23709
4: 24768
5: 21934
6: 21144
7: 23555
8: 23528
9: 20889
Sum:223345
 */