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
