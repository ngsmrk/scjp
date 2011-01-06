/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scjp.sets;

import java.util.LinkedHashSet;
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
public class LinkedHashSetTest {

    private Set<TestKey> set = new LinkedHashSet();

    public LinkedHashSetTest() {
    }

    @Before
    public void setUp() {

        TestKey inner1 = new TestKey("B");
        TestKey inner2 = new TestKey("A");

        set.add(inner1);
        set.add(inner2);
    }

    @After
    public void tearDown() {

        set.clear();
    }

    @Test
    public void testIterationOrder() {

        // entries are unsorted (but order is based on insertion order)
        Iterator it = set.iterator();
        assertEquals("B", ((TestKey)it.next()).getValue());
        assertEquals("A", ((TestKey)it.next()).getValue());
    }

    /**
     * Test modifying set entry value and then try to add the entry again.
     */
    @Test
    public void testModifyingSetEntry() {

        int oldSize = set.size();
        final TestKey inner2 = set.iterator().next();

        System.out.println("Set before modification: " + set);

        // modification of value fools the set so a new element is added
        inner2.setValue("C");
        assertEquals(0, inner2.compareTo(inner2));
        assertEquals(inner2, inner2);
        assertFalse(set.contains(inner2));
        assertTrue(set.add(inner2));

        assertEquals(++oldSize, set.size());
        System.out.println("Set after modification: " + set);
    }

    @Test
    public void testAddingNulls() {
        int oldSize = set.size();
        set.add(null);
        assertEquals(++oldSize, set.size());
    }

}