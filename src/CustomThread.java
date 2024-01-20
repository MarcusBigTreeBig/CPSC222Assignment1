public class CustomThread extends Thread {
    private static int[] timesRun = new int[10];
    private static int nextID = 0;
    private int threadID;
    public CustomThread () {
        if (nextID > timesRun.length-1) {//ensuring array stays at a good size
            int[] temp = timesRun;
            timesRun = new int[temp.length*2];
            for (int i = 0; i < temp.length; i++) {
                timesRun[i] = temp[i];
            }
        }
        threadID = nextID++;
    }
    public synchronized void run () {
        while (true) {
            String str = "Thread ID: " + threadID + "\n" + "Times Run:\n";
            for (int i = 0; i < nextID; i++) {
                str += i + ": " + timesRun[i] + "\n";
            }
            System.out.println(str);
            timesRun[threadID]++;
        }
    }

}
