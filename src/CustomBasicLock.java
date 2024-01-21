public class CustomBasicLock {
    private boolean unlocked;
    public CustomBasicLock () {
        unlocked = true;
    }
    public synchronized CustomBasicLock acquire() throws InterruptedException {
        while (!unlocked) {
            this.wait();
        }
        unlocked = false;
        return this;
    }
    public synchronized void release () {
        unlocked = true;
        notifyAll();
    }
    public synchronized boolean canAcquire(){
        return unlocked;
    }

}
