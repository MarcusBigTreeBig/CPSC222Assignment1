public class CustomBasicLock {
    private boolean unlocked;
    private CustomThreadBasicLock owner;
    public CustomBasicLock () {
        unlocked = true;
    }
    public synchronized CustomBasicLock acquire(CustomThreadBasicLock t) throws InterruptedException {
        while (!unlocked) {
            this.wait();
        }
        unlocked = false;
        owner = t;
        return this;
    }
    public synchronized void release (CustomThreadBasicLock t) {
        if (t == owner) {
            unlocked = true;
            notifyAll();
        }
    }
    public synchronized boolean canAcquire(){
        return unlocked;
    }

}
