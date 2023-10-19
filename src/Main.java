import java.util.Iterator;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Vector<Integer> vec = new Vector<>();
        vec.add(100);
        vec.add(200);
        vec.add(300);
        vec.add(400);
        vec.add(500);

        Runnable myThread = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                Iterator<Integer> it = vec.iterator();
                while (it.hasNext()) {
                    Integer nextEle = it.next();
                    System.out.println("List Value:" + nextEle);
                    if (nextEle.equals(300))
                        vec.remove(nextEle);
                }

            }
        };

        Runnable myThread2 = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                vec.forEach(ele -> System.out.println("Ele: " + ele));
            }
        };

        Thread thread = new Thread(myThread);
        Thread thread2 = new Thread(myThread2);

        thread.start();
        thread2.start();

        System.out.println("This is main thread");

    }
}
