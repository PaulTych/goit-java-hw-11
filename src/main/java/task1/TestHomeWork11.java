package task1;

public class TestHomeWork11 {
    private final static Object MONITOR = new Object();
    private final static int N = 15;
    private static Object monitor = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("-------------------------------Task 1------------------------");
        Counter secundomer = new Counter(MONITOR, 1000);
        Counter5 counter5 = new Counter5(MONITOR, 5);
        secundomer.setDaemon(true);
        counter5.setDaemon(true);
        secundomer.start();
        counter5.start();
        Thread.sleep(30000);

        System.out.println("-------------------------------Task 2------------------------");
        StringOfNumbers sequence = new StringOfNumbers(monitor, N);

        Thread a = new Thread(sequence::fizz);
        a.setName("A");
        Thread b = new Thread(sequence::buzz);
        b.setName("B");
        Thread c = new Thread(sequence::fizzbuzz);
        c.setName("C");
        Thread d = new Thread(sequence::digit);
        d.setName("D");

        a.start();
        b.start();
        c.start();
        d.start();
    }
}
