class MyThread extends Thread {
    boolean suspend = false, stop = false;

    public void run() {
        try {
            for (int i = 1; i <= 15 && !stop; i++) {
                synchronized (this) {
                    while (suspend) {
                        wait();
                    }

                    if (stop) {
                        break;
                    }

                    System.out.println("Running :" + i);
                }

                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread was interrupted.");
        }
    }

    synchronized void mySuspend() {
        suspend = true;
    }

    synchronized void myResume() {
        suspend = false;
        notify();
    }

    synchronized void myStop() {
        stop = true;
        suspend = false;
        notify();
    }
}

public class SuspendResumeStop {
    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();

        t.start();

        Thread.sleep(900);
        t.mySuspend();
        System.out.println("Suspended");

        Thread.sleep(1000);
        t.myResume();
        System.out.println("Resumed");

        Thread.sleep(900);
        t.myStop();

        t.join();
        System.out.println("Stopped");
    }
}
