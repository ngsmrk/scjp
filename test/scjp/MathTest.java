/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scjp;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Angus
 */
public class MathTest {

    public MathTest() {
    }

    @Test
    public void testMin() {

        // returns value closest to Integer.MIN_VALUE
        assertEquals(1, Math.min(1, 2));
        assertEquals(-2, Math.min(-1, -2));
        assertEquals(-2, Math.min(1, -2));
    }

    @Test
    public void testMax() {

        // returns value closest to Integer.MAX_VALUE
        assertEquals(2, Math.max(1, 2));
        assertEquals(-1, Math.max(-1, -2));
        assertEquals(1, Math.max(1, -2));
    }

    @Test
    public void testRound() {

        // round adds 1/2 and then takes that number
        assertEquals(2, Math.round(1.59));
        assertEquals(-2, Math.round(-1.59));

        assertEquals(2, Math.round(1.5));
        assertEquals(-1, Math.round(-1.5));

        assertEquals(1, Math.round(1.49));
        assertEquals(-1, Math.round(-1.49));
    }

    @Test
    public void testMinDoubles() {

        // min returns the number closest to negative infinity for doubles
        assertEquals(1.0, Math.min(1.0, 2.0), 0.0);
        assertEquals(-2.0, Math.min(-1.0, -2.0), 0.0);
        assertEquals(-2.0, Math.min(1.0, -2.0), 0.0);
    }

    @Test
    public void testMaxDoubles() {

        // max returns the number closest to infinity for doubles
        assertEquals(2.0, Math.max(1.0, 2.0), 0.0);
        assertEquals(-1.0, Math.max(-1.0, -2.0), 0.0);
        assertEquals(1.0, Math.max(1.0, -2.0), 0.0);
    }
}
