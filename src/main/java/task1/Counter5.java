package task1;

public class Counter5 extends Thread {
    private final Object monitor;
    public int count;

    public Counter5(Object monitor, int count) {
        this.monitor = monitor;
        this.count = count;
    }

    @Override
    public void run() {
        int i = 1;
        while (true) {
            try {
                synchronized (monitor) {
                    if (i == this.count) {
                        System.out.println("period "+this.count+" sec passed!");
                        i = 0;
                    }
                    i++;
                    monitor.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

