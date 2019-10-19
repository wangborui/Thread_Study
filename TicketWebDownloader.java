package thread;

public class TicketWebDownloader implements Runnable{
    private int ticketNums = 99;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
            if (ticketNums < 0) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
        }
    }

    public static void main(String[] args) {
        TicketWebDownloader ticketWebDownloader = new TicketWebDownloader();
        new Thread(ticketWebDownloader, "Thread A").start();
        new Thread(ticketWebDownloader, "Thread B").start();
        new Thread(ticketWebDownloader, "Thread C").start();

    }
}
