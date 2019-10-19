package thread;

import java.util.concurrent.*;

public class CallableRacer implements Callable<Integer> {
    private String winner;

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i <= 100; i++) {
            String threadName = Thread.currentThread().getName();
            if (threadName.equals("pool-1-thread-1") && i % 10 == 0) {
                //Simulate Rabbit Resting while turtle is running
                Thread.sleep(2);
            }
            System.out.println(threadName + " == > " + i);
            if (isGameOver(i)) {
                return i;
            }
        }
        return null;
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

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CallableRacer racer = new CallableRacer();

        Future<Integer> result1 = executorService.submit(racer);
        Future<Integer> result2 = executorService.submit(racer);

        int r1 = result1.get();
        int r2 = result2.get();

        System.out.println(r1 + "-->" + r2);
        executorService.shutdownNow();

    }
}
