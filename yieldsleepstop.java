class Demo extends Thread {
    volatile boolean running = true;

    Demo(String name) { super(name); }

    public void run() {
        for (int i = 1; i <= 5 && running; i++) {
            System.out.println(getName() + " -> " + i);

            if (i == 3) {
                System.out.println(getName() + " yielding...");
                Thread.yield();
            }

            if (i == 4) {
                System.out.println(getName() + " sleeping...");
                try {
             Thread.sleep(1000);
             } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
              return;
             }
            }
        }
        System.out.println(getName() + " stopped");
    }

    void stopThread() { running = false; }
}

public class yieldsleepstop {
    public static void main(String[] args) throws Exception {
        Demo a = new Demo("Thread-A");
        Demo b = new Demo("Thread-B");

        a.start();
        b.start();

        Thread.sleep(1500);
        a.stopThread();
        b.stopThread();
    }
}
