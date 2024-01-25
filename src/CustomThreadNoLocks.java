/**
 * Thread that does not use locks
 * Prints out how many times each thread has run
 */
public class CustomThreadNoLocks extends Thread {
    private static int[] timesRun = new int[10];
    private static int nextID = 0;
    private int threadID;

    /**
     * Creates a new Thread
     */
    public CustomThreadNoLocks() {
        if (nextID > timesRun.length-1) {//ensuring array stays at a good size
            int[] temp = timesRun;
            timesRun = new int[temp.length*2];
            for (int i = 0; i < temp.length; i++) {
                timesRun[i] = temp[i];
            }
        }
        threadID = nextID++;
    }

    /**
     * Continuously print out how many times easch thread has run
     */
    @Override
    public void run () {
        while (true) {
            //adding all parts of string together, so output can be read when threads run out of order
            String str = "Thread ID: " + threadID + "\n" + "Times Run:\n";
            int sum = 0;
            for (int i = 0; i < nextID; i++) {
                str += i + ": " + timesRun[i] + "\n";
                sum += timesRun[i];
            }
            str += "Sum:" + sum + "\n";
            System.out.println(str);
            timesRun[threadID]++;
        }
    }

}
