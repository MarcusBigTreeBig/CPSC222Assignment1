/**
 * Non reentrant lock
 */
public class CustomBasicLock {
    private boolean unlocked;
    private CustomThreadBasicLock owner;

    /**
     * Creates the lock
     */
    public CustomBasicLock () {
        unlocked = true;
    }

    /**
     * Gives the lock to a certain Thread
     *
     * @param t the Thread being used to access this lock
     * @return this
     * @throws InterruptedException
     */
    public synchronized CustomBasicLock acquire(CustomThreadBasicLock t) throws InterruptedException {
        while (!unlocked) {
            this.wait();
        }
        unlocked = false;
        owner = t;
        return this;
    }

    /**
     * Lets a thread release the lock
     *
     * @param t the Thread attempting to release the lock
     */
    public synchronized void release (CustomThreadBasicLock t) {
        if (t == owner) {
            unlocked = true;
            notifyAll();
        }
    }

    /**
     *
     * @return true if the lock is not acquired by any thread
     */
    public synchronized boolean canAcquire(){
        return unlocked;
    }

}
