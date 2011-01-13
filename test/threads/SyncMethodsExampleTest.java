package threads;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

/**
 * .
 *
 * @author Initial: amark
 * @version 1.0
 */
public class SyncMethodsExampleTest {

    @Test
    public void testRun() {

        List<String> output = new ArrayList();

        SyncMethodsExample.run(output);        

        assertEquals(6, output.size());

        assertEquals("thread1: 1", output.get(0));
        assertEquals("thread1: 2", output.get(1));
        assertEquals("thread1: 3", output.get(2));

        assertEquals("thread2: 1", output.get(3));
        assertEquals("thread2: 2", output.get(4));
        assertEquals("thread2: 3", output.get(5));
    }
}
