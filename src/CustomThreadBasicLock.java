/**
 * This thread prints out how many times each thread has run
 * It uses a non reentrant lock to ensure it prints correct values
 */
public class CustomThreadBasicLock extends Thread{
    private static int[] timesRun = new int[10];
    private static int nextID = 0;
    private int threadID;
    CustomBasicLock lock;

    /**
     * Creates a thread that has a lock it will only run if it has acquired
     *
     * @param lock the lock that's being used by the threads
     */
    public CustomThreadBasicLock(CustomBasicLock lock) {
        if (nextID > timesRun.length-1) {//ensuring array stays at a good size
            int[] temp = timesRun;
            timesRun = new int[temp.length*2];
            for (int i = 0; i < temp.length; i++) {
                timesRun[i] = temp[i];
            }
        }
        threadID = nextID++;
        this.lock = lock;
    }

    /**
     * If it has acquired the lock,
     * It prints out how many times each thread has run
     */
    @Override
    public void run () {
        while (true) {
            try {
                lock = lock.acquire(this);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String str = "Thread ID: " + threadID + "\n" + "Times Run:\n";
            int sum = 0;
            for (int i = 0; i < nextID; i++) {
                str += i + ": " + timesRun[i] + "\n";
                sum += timesRun[i];
            }
            str += "Sum:" + sum + "\n";
            System.out.println(str);
            timesRun[threadID]++;
            lock.release(this);
        }
    }
}
