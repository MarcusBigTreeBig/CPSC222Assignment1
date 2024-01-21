public class CustomThreadReentrantLock extends Thread{
    private static int[] timesRun = new int[10];
    private static int nextID = 0;
    private int threadID;
    CustomReentrantLock lock;
    public CustomThreadReentrantLock(CustomReentrantLock lock) {
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

    @Override
    public void run () {
        while (true) {
            try {
                lock.acquire(this);
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
            try {
                lock.acquire(this);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock.release(this);
        }
    }
}
