package thread;

public class ThreadDownloader extends Thread {
    private String url;
    private String name;

    public ThreadDownloader(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader wd = new WebDownloader();
        wd.download(url, name);
        System.out.println(name);
    }

    public static void main(String[] args) {
        ThreadDownloader threadDownloader1 = new ThreadDownloader("https://images.ctfassets.net/dsd9jdvxe1xf/6qIw0UUc3mcUIiSoSg6WYm/25cb3db47e39205cd7cc81f9914dd03d/spring-vgs-java.png","spring.png");
        ThreadDownloader threadDownloader2 = new ThreadDownloader("https://i.kfs.io/album/global/46819190,1v1/fit/500x500.jpg","守破离.jpg");
        ThreadDownloader threadDownloader3 = new ThreadDownloader("https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Coin_Toss_%283635981474%29.jpg/440px-Coin_Toss_%283635981474%29.jpg","coin.jpg");

        threadDownloader1.start();
        threadDownloader2.start();
        threadDownloader3.start();
    }
}
