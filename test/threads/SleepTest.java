package threads;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * .
 *
 * @author Initial: amark
 * @version 1.0
 */
public class SleepTest {

    @Test
    public void testSleep() throws InterruptedException {

        long startTime = System.currentTimeMillis();

        final int delay = 1000;
        Thread.currentThread().sleep(delay);

        assertTrue(System.currentTimeMillis() >= startTime + delay);
    }
}
