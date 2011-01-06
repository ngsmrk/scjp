/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scjp.sets;

import java.util.TreeSet;
import java.util.Iterator;
import scjp.maps.TestKey;
import java.util.Set;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Angus
 */
public class TreeSetTest {

    private Set<TestKey> set2 = new TreeSet();

    @Before
    public void setUp() {

        TestKey inner1 = new TestKey("A");
        TestKey inner2 = new TestKey("B");

        set2.add(inner1);
        set2.add(inner2);
    }

    @After
    public void tearDown() {

        set2.clear();
    }

    @Test
    public void testIterationOrder() {

        // entries are sorted
        Iterator it = set2.iterator();
        assertEquals("A", ((TestKey)it.next()).getValue());
        assertEquals("B", ((TestKey)it.next()).getValue());
    }

    /**
     * Test modifying set entry value and then try to add the entry again.
     */
    @Test
    public void testModifyingSetEntry() {

        int oldSize = set2.size();
        final TestKey inner2 = set2.iterator().next();

        System.out.println("Set before modification: " + set2);

        // modification of value does not fool the set
        inner2.setValue("C");
        assertEquals(0, inner2.compareTo(inner2));
        assertEquals(inner2, inner2);
        assertTrue(set2.contains(inner2));
        assertFalse(set2.add(inner2));

        assertEquals(oldSize, set2.size());
        System.out.println("Set after modification: " + set2);
    }

    @Test (expected=NullPointerException.class)
    public void testAddingNulls() {
        set2.add(null);
    }

}