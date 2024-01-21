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