/**
 * Reentrant Lock
 */
public class CustomReentrantLock {
    private int acquires;
    CustomThreadReentrantLock owner;

    /**
     * Creates the lock
     */
    public CustomReentrantLock () {
        acquires = 0;
    }

    /**
     * Allows a Thread to claim a lock
     *
     * @param t the Thread that's attempting to claim the lock
     * @return this
     * @throws InterruptedException
     */
    public synchronized CustomReentrantLock acquire(CustomThreadReentrantLock t) throws InterruptedException {
        while (acquires > 0 && t != owner) {
            this.wait();
        }
        acquires++;
        owner = t;
        return this;
    }

    /**
     * Allows a thread to release a lock
     * @param t the thread attempting to release the lock
     */
    public synchronized void release (CustomThreadReentrantLock t) {
        if (acquires > 0 && t == owner) {
            acquires--;
        }
        notifyAll();
    }

    /**
     *
     * @return true if no thread has acquired the lock
     */
    public synchronized boolean canAcquire(){
        return acquires == 0;
    }
}
