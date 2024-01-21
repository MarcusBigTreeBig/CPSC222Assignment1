public class CustomReentrantLock {
    private int acquires;
    CustomThreadReentrantLock owner;

    public CustomReentrantLock () {
        acquires = 0;
    }
    public synchronized CustomReentrantLock acquire(CustomThreadReentrantLock t) throws InterruptedException {
        while (acquires > 0 && t != owner) {
            this.wait();
        }
        acquires++;
        owner = t;
        return this;
    }
    public synchronized void release (CustomThreadReentrantLock t) {
        if (acquires > 0 && t == owner) {
            acquires--;
        }
        notifyAll();
    }
    public synchronized boolean canAcquire(){
        return acquires == 0;
    }
}
