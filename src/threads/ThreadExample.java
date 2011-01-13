package threads;

/**
 * .
 *
 * @author Initial: amark
 * @version 1.0
 */

import java.util.Vector;

@SuppressWarnings({"UseOfObsoleteCollectionType"})
public class ThreadExample {

    // use vector because it is synchronised
    private final Vector<String> threadNames = new Vector<String>();

    public static void main(String[] args) {
        ThreadExample test = new ThreadExample();
        test.ThreadExample(4);
        
        System.out.println(test.threadNames);
    }

    private void ThreadExample(int numOfThreads) {

        // always start all the threads and then do join
        // if you do the 2 things together the second thread will not start
        // until the 1st thread has finished (and so on for all subsequent threads)
        Thread[] threads = new Thread[numOfThreads];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new ThreadExample.MyThread();
            threads[i].start();
        }
        
        for (Thread thread : threads) {
            try {

                // current thread must wait until these have finished
                thread.join();
            } catch (InterruptedException ignore) {
            }
        }
    }

    class MyThread extends Thread {

        @Override
        public void run() {

            // wait a bit
            for (int i = 0; i < 1000000; i++) {}
            
            synchronized (threadNames) { threadNames.add(getName()); }
        }
    }
}
