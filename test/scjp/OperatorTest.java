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
public class OperatorTest {

    public OperatorTest() {
    }

    @Test
    public void testBooleanAndOperators() {

        boolean falseB = false;
        boolean trueB = true;

        assertTrue(trueB & trueB);
        assertFalse(falseB & falseB);
        assertFalse(falseB & trueB);
        assertFalse(trueB & falseB);

        // now try short circuit operators
        assertTrue(trueB && trueB);
        assertFalse(falseB && falseB);
        assertFalse(falseB && trueB);
        assertFalse(trueB && falseB);
    }

    @Test
    public void testBooleanOrOperators() {

        boolean falseB = false;
        boolean trueB = true;

        assertTrue(trueB | trueB);
        assertFalse(falseB | falseB);
        assertTrue(falseB | trueB);
        assertTrue(trueB | falseB);

        // now try short circuit operators
        assertTrue(trueB || trueB);
        assertFalse(falseB || falseB);
        assertTrue(falseB || trueB);
        assertTrue(trueB || falseB);
    }

    @Test
    public void testXOROperators() {

        boolean falseB = false;
        boolean trueB = true;

        // XOR only returns true if ONLY ONE side of the statement evaluates to true
        assertFalse(trueB ^ trueB);
        assertFalse(falseB ^ falseB);
        assertTrue(falseB ^ trueB);
        assertTrue(trueB ^ falseB);
    }
}