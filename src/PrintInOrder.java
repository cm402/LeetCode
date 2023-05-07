import java.util.concurrent.Semaphore;

public class PrintInOrder {

    final Semaphore second = new Semaphore(0);
    final Semaphore third = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        second.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        second.acquire();
        printSecond.run();
        third.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        third.acquire();
        printThird.run();
    }
}
