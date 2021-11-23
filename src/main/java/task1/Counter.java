package task1;

public class Counter extends Thread {
    private long delta;
    private final int period;
    private final Object monitor;
    public int seconds;

    public Counter(Object monitor, int period) {
        this.period = period;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        while (true) {

            synchronized (monitor) {
                counter();
                monitor.notifyAll();
            }
            delta = (System.currentTimeMillis() - start) / this.period;
            System.out.println((int) delta + " sec passed");
        }
    }

    public void counter() {
        try {
            Thread.sleep(period);
            this.seconds++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getSeconds() {
        return seconds;
    }
}
