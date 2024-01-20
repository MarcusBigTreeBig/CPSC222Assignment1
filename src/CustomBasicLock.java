public class CustomBasicLock {
    public CustomBasicLock acquire() {
        return null;
    }
    public void release () {}
    public boolean canAcquire(){
        return false;
    }

    public void customNotify () {}

}
