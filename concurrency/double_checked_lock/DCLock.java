package concurrency.double_checked_lock;

public class DCLock {
    private volatile static DCLock uniqueInstance;

    private DCLock() {}

    public static DCLock getUniqueInstance() {
        if (uniqueInstance == null) {
            synchronized (DCLock.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new DCLock();
                }
            }
        }
        return uniqueInstance;
    }
}