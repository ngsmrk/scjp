/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scjp.lists;

import scjp.maps.TestKey;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Angus
 */
public class LinkedListTest {

    List<TestKey> myList = new LinkedList();

    public LinkedListTest() {
    }

    @Before
    public void setUp() {
        myList.add(new TestKey("2"));
        myList.add(new TestKey("1"));
        myList.add(new TestKey("2"));        
    }

    @After
    public void tearDown() {
        myList.clear();
    }

    @Test
    public void testAddNulls() {

        // nulls (and duplicates) allowed
        int oldSize = myList.size();
        myList.add(null);
        myList.add(null);
        assertEquals(oldSize + 2, myList.size());
    }

    @Test
    public void testIterationOrder() {

        // order is insertion order
        final Iterator iterator = myList.iterator();
        assertEquals("2", ((TestKey)iterator.next()).getValue());
        assertEquals("1", ((TestKey)iterator.next()).getValue());
        assertEquals("2", ((TestKey)iterator.next()).getValue());
    }

    @Test
    public void testModifyEntry() {
        TestKey entry = myList.get(0);
        entry.setValue("TEST");

        assertEquals("TEST", myList.get(0).getValue());
    }
}