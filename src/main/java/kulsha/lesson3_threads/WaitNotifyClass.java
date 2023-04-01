package kulsha.lesson3_threads;

public class WaitNotifyClass {
    private final Object mon = new Object();
    private volatile String currentWord = "Ping";

    public static void main(String[] args) {
        WaitNotifyClass waitNotifyClass = new WaitNotifyClass();
        Thread thread1 = new Thread(() -> waitNotifyClass.printPing());
        Thread thread2 = new Thread(() -> waitNotifyClass.printPong());
        thread1.start();
        thread2.start();
    }

    public void printPing(){
        synchronized (mon){
            try{
                for (int i = 0; i < 10; i++) {
                    while (currentWord.equals("Ping")){
                        mon.wait();
                    }
                    System.out.print("Ping");
                    currentWord = "Pong";
                    mon.notify();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void printPong(){
        synchronized (mon){
            try{
                for (int i = 0; i < 10; i++) {
                    while (currentWord.equals("Pong")){
                        mon.wait();
                    }
                    System.out.print("Pong");
                    currentWord = "Ping";
                    mon.notify();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
