public class BasicThreadsMain {
    public static void main (String[] args) {
        int n = 10;
        CustomThread[] threads = new CustomThread[n];
        for (int i = 0; i < n; i++) {
            threads[i] = new CustomThread();
        }
    }
}
