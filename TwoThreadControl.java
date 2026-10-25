
class MyThread extends Thread {
    volatile boolean suspend = false;
    volatile boolean stop = false;

    MyThread(String name) {
        super(name);
    }

    public void run() {
        try {
            for (int i = 1; i <= 15 && !stop; i++) {
                synchronized (this) {
                    while (suspend && !stop) {
                        wait();
                    }
                }

                if (stop) break;

                System.out.println(getName() + " Running: " + i);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    synchronized void mySuspend() {
        suspend = true;
    }

    synchronized void myResume() {
        suspend = false;
        notifyAll();
    }

    synchronized void myStop() {
        stop = true;
        suspend = false;
        notifyAll();
    }
}

public class TwoThreadControl {
    public static void main(String[] args)
            throws InterruptedException {

        MyThread t1 = new MyThread("Thread-1");
        MyThread t2 = new MyThread("Thread-2");

        t1.start();
        t2.start();

        Thread.sleep(900);
        t1.mySuspend();
        t2.mySuspend();
        System.out.println("Both Threads Suspended");

        Thread.sleep(1000);
        t1.myResume();
        t2.myResume();
        System.out.println("Both Threads Resumed");

        Thread.sleep(900);
        t1.myStop();
        t2.myStop();

        t1.join();
        t2.join();

        System.out.println("Both Threads Stopped");
    }
}

