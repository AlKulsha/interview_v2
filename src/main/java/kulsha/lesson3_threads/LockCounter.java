package kulsha.lesson3_threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCounter {
    Lock lock = new ReentrantLock();
    private int value;

    public int getValue() {
        return value;
    }

    public void increment(){
        lock.lock();
        try{
            value++;
        }finally {
            lock.unlock();
        }

    }

    public void decrement(){
        lock.lock();
        try{
            value--;
        }finally {
            lock.unlock();
        }
    }
}
