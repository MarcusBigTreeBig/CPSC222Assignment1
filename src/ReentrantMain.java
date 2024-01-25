/**
 *Creates 10 Threads
 * These threads output how many times each thread has run
 * The threads use reentrant locks
 * The first thread will always reacquire the lock before releasing it to demonstrate the reentrant lock.
 */
public class ReentrantMain {
    public static void main (String[] args) {
        int n = 10;
        CustomThreadReentrantLock[] threads = new CustomThreadReentrantLock[n];
        CustomReentrantLock lock = new CustomReentrantLock();
        for (int i = 0; i < n; i++) {
            threads[i] = new CustomThreadReentrantLock(lock);
            threads[i].start();
        }
    }
}

/*
Some Output:

Thread 0 reacquires the lock before releasing each time, so it is the only one to have run, as shown by this data

Thread ID: 0
Times Run:
0: 384810
1: 0
2: 0
3: 0
4: 0
5: 0
6: 0
7: 0
8: 0
9: 0
Sum:384810
 */