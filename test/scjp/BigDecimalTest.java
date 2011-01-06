/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scjp;

import java.math.RoundingMode;
import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Angus
 */
public class BigDecimalTest {

    public BigDecimalTest() {
    }

    @Test
    public void testRoundingWithNegativeNumbers() {

        BigDecimal big1 = new BigDecimal(-11);
        BigDecimal big2 = new BigDecimal(2);

        assertEquals(-6.0, big1.divide(big2, RoundingMode.FLOOR).doubleValue(), 0.0);
        assertEquals(-5.0, big1.divide(big2, RoundingMode.CEILING).doubleValue(), 0.0);

        assertEquals(-5.0, big1.divide(big2, RoundingMode.DOWN).doubleValue(), 0.0);
        assertEquals(-6.0, big1.divide(big2, RoundingMode.UP).doubleValue(), 0.0);

        assertEquals(-5.0, big1.divide(big2, RoundingMode.HALF_DOWN).doubleValue(), 0.0);
        assertEquals(-6.0, big1.divide(big2, RoundingMode.HALF_UP).doubleValue(), 0.0);
        assertEquals(-6.0, big1.divide(big2, RoundingMode.HALF_EVEN).doubleValue(), 0.0);
    }

    @Test
    public void testRoundingWithPositiveNumbers() {

        BigDecimal big1 = new BigDecimal(11);
        BigDecimal big2 = new BigDecimal(2);

        assertEquals(5.0, big1.divide(big2, RoundingMode.FLOOR).doubleValue(), 0.0);
        assertEquals(6.0, big1.divide(big2, RoundingMode.CEILING).doubleValue(), 0.0);

        assertEquals(5.0, big1.divide(big2, RoundingMode.DOWN).doubleValue(), 0.0);
        assertEquals(6.0, big1.divide(big2, RoundingMode.UP).doubleValue(), 0.0);

        assertEquals(5.0, big1.divide(big2, RoundingMode.HALF_DOWN).doubleValue(), 0.0);
        assertEquals(6.0, big1.divide(big2, RoundingMode.HALF_UP).doubleValue(), 0.0);
        assertEquals(6.0, big1.divide(big2, RoundingMode.HALF_EVEN).doubleValue(), 0.0);
    }
}
