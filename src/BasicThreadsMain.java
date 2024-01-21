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
