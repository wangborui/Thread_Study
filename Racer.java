package thread;

public class Racer implements Runnable {
    private String winner;
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            String threadName = Thread.currentThread().getName();
            if (threadName.equals("rabbit")) {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(threadName + " == > " + i);
            if (isGameOver(i)) {
                break;
            }
        }
    }

    private boolean isGameOver(int i) {
        if (winner != null) {
            return true;
        } else {
            if (i == 100) {
                winner = Thread.currentThread().getName();
                System.out.println("Winner is ==> " + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Racer racer = new Racer();
        new Thread(racer, "rabbit").start();
        new Thread(racer, "turtle").start();

    }
}
