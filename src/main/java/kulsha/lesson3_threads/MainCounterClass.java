package kulsha.lesson3_threads;

public class MainCounterClass {
    public static void main(String[] args) throws InterruptedException {
//        Counter counter = new Counter();
        LockCounter lockCounter = new LockCounter();
        Thread firstThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                lockCounter.increment();

            }
        });
        Thread secondThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                lockCounter.decrement();
            }
        });
        firstThread.start();
        secondThread.start();
        firstThread.join();
        secondThread.join();
        System.out.println(lockCounter.getValue());



    }
}
