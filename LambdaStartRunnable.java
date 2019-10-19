package thread;

/**
 * Lamda Expression
 */
public class LambdaStartRunnable {
    //    static class Test implements Runnable {
//        @Override
//        public void run() {
//            for (int i = 0; i < 20; i++) {
//                System.out.println("听歌");
//            }
//        }
//    }
    public static void main(String[] args) {
//        //Create Implementation
//        StartRunnable ts = new StartRunnable();
//        //Create Abstract Class
//        Thread t = new Thread(ts);
//        //Start
//        t.start(); //Not guranteed to run right away, CPU allocation time varies
//        class Test implements Runnable {
//            @Override
//            public void run() {
//                for (int i = 0; i < 20; i++) {
//                    System.out.println("听歌");
//                }
//            }
//        }


//        new Thread(new Runnable() {
//                        @Override
//            public void run() {
//                for (int i = 0; i < 20; i++) {
//                    System.out.println("听歌");
//                }
//            }
//        }).start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("听歌");
            }
        }).start();
        for (int i = 0; i < 20; i++) {
            System.out.println("敲代码");
        }
    }
}
