public class CustomLock {
    public CustomLock acquire() {
        return null;
    }
    public void release () {}
    public boolean canAcquire(){
        return false;
    }

    public void customNotify () {}

}
