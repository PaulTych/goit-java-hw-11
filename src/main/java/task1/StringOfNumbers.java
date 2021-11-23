package task1;

public class StringOfNumbers {
    private int number = 1;
    private final int n;
    private final Object monitor;

    public StringOfNumbers(Object monitor, int n) {
        this.monitor = monitor;
        this.n = n;
    }

    public int getNumber() {
        return number;
    }

    private synchronized void nextNumb() {
        this.number++;
    }

    public void fizz() {
        synchronized (monitor) {
            while (number <= n) {
                if (number % 3 == 0 && number % 5 != 0) {
                    System.out.print(", fizz");
                    nextNumb();
                    monitor.notifyAll();
                } else {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void buzz() {
        synchronized (monitor) {
            while (number <= n) {
                if (number % 3 != 0 && number % 5 == 0) {
                    System.out.print(", buzz");
                    nextNumb();
                    monitor.notifyAll();
                } else {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void fizzbuzz() {
        synchronized (monitor) {
            while (number <= n) {
                if (number % 3 == 0 && number % 5 == 0) {
                    System.out.print(", fizzbuzz");
                    nextNumb();
                    monitor.notifyAll();
                } else {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void digit() {
        synchronized (monitor) {
            while (number <= n) {
                if (number % 3 != 0 && number % 5 != 0) {
                    if (number==1) {
                        System.out.print(number);
                    } else {
                        System.out.print(", "+number);
                    }
                    nextNumb();
                    monitor.notifyAll();
                } else {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
