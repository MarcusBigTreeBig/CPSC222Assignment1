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
