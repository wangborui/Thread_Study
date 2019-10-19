package thread;

/**
 * First method to create Thread in Java
 * 1. Creation: Implement Thread and rewrite run
 * 2. Running: Create Subclass and start
 */
public class StartThread extends Thread {
    public static void main(String[] args) {
        StartThread ts = new StartThread();
        ts.start();
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
