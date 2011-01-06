/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scjp.sets;

import java.util.HashSet;
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
public class HashSetTest {

    private Set<TestKey> set = new HashSet();

    public HashSetTest() {
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

        // entries are unsorted (and order is not based on insertion order)
        Iterator it = set.iterator();
        assertEquals("A", ((TestKey)it.next()).getValue());
        assertEquals("B", ((TestKey)it.next()).getValue());
    }

    /**
     * Test modifying set entry value and then try to add the entry again.
     */
    @Test
    public void testModifyingSetEntry() {

        int oldSize = set.size();
        final TestKey key = set.iterator().next();

        System.out.println("Set before modification: " + set);

        // modification of value fools the set so a new element is added
        key.setValue("C");
        assertEquals(0, key.compareTo(key));
        assertEquals(key, key);
        assertFalse(set.contains(key));
        assertTrue(set.add(key));

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