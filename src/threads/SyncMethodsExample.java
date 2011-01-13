package threads;

import java.util.List;

/**
 * .
 *
 * @author Initial: amark
 * @version 1.0
 */
public class SyncMethodsExample extends Thread {

    static final String[] msg = {"1", "2", "3"};
    
    private final List<String> output;

    public SyncMethodsExample(String id, List<String> output) {
        super(id);
        this.output = output;
    }

    public static void run(List<String> output) {

        SyncMethodsExample thread1 = new SyncMethodsExample("thread1: ", output);
        SyncMethodsExample thread2 = new SyncMethodsExample("thread2: ", output);
        thread1.start();
        thread2.start();
        boolean t1IsAlive = true;
        boolean t2IsAlive = true;
        do {
            if (t1IsAlive && !thread1.isAlive()) {
                t1IsAlive = false;
            }
            if (t2IsAlive && !thread2.isAlive()) {
                t2IsAlive = false;
            }
        } while (t1IsAlive || t2IsAlive);
    }

    void randomWait() {
        try {
            Thread.currentThread().sleep(Math.round(100 * Math.random()));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void run() {
        SynchronizedOutput.displayList(getName(), msg, output);
    }
}

class SynchronizedOutput {

    // if the 'synchronized' keyword is removed, the message
    // is displayed in random fashion
    public static synchronized void displayList(String name, String list[], List<String> output) {

        for (String value : list) {
            SyncMethodsExample t = (SyncMethodsExample) Thread.currentThread();
            t.randomWait();
            final String message = name + value;

            output.add(message);
        }
    }
}
