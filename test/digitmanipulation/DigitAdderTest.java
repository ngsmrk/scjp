package digitmanipulation;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * .
 *
 * @author Initial: amark
 * @version 1.0
 */
public class DigitAdderTest {

    @Test
    public void testAddDigits() {

        test(126, 9);
        test(47, 11);
        test(101, 2);
        test(5, 5);
    }

    private void test(int input, int expected) {
        test(input, expected, new StringBasedDigitAdder());
        test(input, expected, new NonRecursiveModulusBasedDigitAdder());
        test(input, expected, new RecursiveModulusBasedDigitAdder());
    }

    private void test(int input, int expected, DigitAdder adder) {
        int output = adder.add(input);
        assertEquals(expected, output);
    }

}
