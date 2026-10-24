public class ThreadPriority extends Thread {

    public void run() {
        for(int i=1; i<=3;i++){
        System.out.println(getName() + " Priority: " + getPriority()+"->"+ i );
        }
    }

    public static void main(String[] args) {

        ThreadPriority t1 = new ThreadPriority();
        ThreadPriority t2 = new ThreadPriority();
        ThreadPriority t3 = new ThreadPriority();

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
    }
}