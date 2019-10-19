package thread;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.concurrent.*;

public class CallableDownloader implements Callable<Boolean> {
    private String url;
    private String name;

    public CallableDownloader(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception{
        WebDownloader wd = new WebDownloader();
        wd.download(url, name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDownloader threadDownloader1 = new CallableDownloader("https://images.ctfassets.net/dsd9jdvxe1xf/6qIw0UUc3mcUIiSoSg6WYm/25cb3db47e39205cd7cc81f9914dd03d/spring-vgs-java.png","spring.png");
        CallableDownloader threadDownloader2 = new CallableDownloader("https://i.kfs.io/album/global/46819190,1v1/fit/500x500.jpg","守破离.jpg");
        CallableDownloader threadDownloader3 = new CallableDownloader("https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Coin_Toss_%283635981474%29.jpg/440px-Coin_Toss_%283635981474%29.jpg","coin.jpg");

        ExecutorService service = Executors.newFixedThreadPool(3);

        Future<Boolean> result1 = service.submit(threadDownloader1);
        Future<Boolean> result2 = service.submit(threadDownloader2);
        Future<Boolean> result3 = service.submit(threadDownloader3);

        boolean r1 = result1.get();
        boolean r2 = result2.get();
        boolean r3 = result3.get();

        service.shutdownNow();
    }
}
