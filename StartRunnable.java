package thread;

/**
 * Second method to create Thread in Java
 * 1. Creation: Implement Runnable and rewrite run
 * 2. Running: Create Subclass and Thread and start
 */
public class StartRunnable implements Runnable {
    public static void main(String[] args) {
//        //Create Implementation
//        StartRunnable ts = new StartRunnable();
//        //Create Abstract Class
//        Thread t = new Thread(ts);
//        //Start
//        t.start(); //Not guranteed to run right away, CPU allocation time varies

        new Thread(new StartRunnable()).start();
        for (int i = 0; i < 20; i++) {
            System.out.println("敲代码");
        }
    }

    /**
     * Thread Entry Point
     */
    @Override
    public void run(){
        for (int i = 0; i < 20; i++) {
            System.out.println("听歌");
        }
    }
}
