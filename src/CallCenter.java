import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class CallCenter {
    private static final Queue<String> calls = new LinkedBlockingQueue<>();
    private static final int PAUSE = 1000;
    private static final int CALL_PROCESSING = 3000;

    public void call() {
        calls.offer(Thread.currentThread().getName());
        try {
            Thread.sleep(PAUSE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Вызов " + Thread.currentThread().getName());
    }

    public void takeCall() {
        while (!(calls.peek() == null)) {
            try {
                Thread.sleep(CALL_PROCESSING);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (calls.peek() == null) {
                Thread.currentThread().interrupt();
                break;
            }
            System.out.println("Специалист " + Thread.currentThread().getName() + " обработал вызов " + calls.poll());
        }
    }
}
