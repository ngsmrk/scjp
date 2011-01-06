/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scjp.maps;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Angus
 */
public class TreeMapTest {

    private Map<TestKey, String> myMap = new TreeMap();

    public TreeMapTest() {
    }

    @Before
    public void setUp() {
        myMap.put(new TestKey("1"), "A");
        myMap.put(new TestKey("1"), "C");
        myMap.put(new TestKey("2"), "B");
    }

    @After
    public void tearDown() {
        myMap.clear();
    }

    @Test (expected=NullPointerException.class)
    public void testAddNulls() {
        myMap.put(null, "C");
    }

    @Test
    public void testIterationOrder() {

        // test size
        assertEquals(2, myMap.size());
        final Collection<String> values = myMap.values();
        final Iterator<String> iterator = values.iterator();
        assertEquals("C", iterator.next());
        assertEquals("B", iterator.next());
    }

    @Test
    public void testModifyingKey() {

        int oldSize = myMap.size();
        TestKey key = myMap.keySet().iterator().next();

        System.out.println("Map before modification: " + myMap);

        // modification of value does not fool the Map
        key.setValue("C");
        assertEquals(0, key.compareTo(key));
        assertEquals(key, key);
        assertTrue(myMap.containsKey(key));
        assertNotNull(myMap.put(key, "TEST"));

        assertEquals(oldSize, myMap.size());
        System.out.println("Map after modification: " + myMap);
    }

    @Test
    public void testMapWithFixedComparisonObject() {

       class AlwaysComparableKey implements Comparable {
           String value;

           AlwaysComparableKey(String value) {
               this.value = value;
           }

            public int compareTo(Object o) {
                return 0;
            }
       }

       // using compareTo that returns 0 basically means you cannot have more than 1 entry
       final Map<AlwaysComparableKey, String> theMap = new TreeMap();
       final AlwaysComparableKey key1 = new AlwaysComparableKey("key1");
       theMap.put(key1, "value1");

       final AlwaysComparableKey key2 = new AlwaysComparableKey("key2");
       theMap.put(key2, "value2");
       assertEquals(1, theMap.size());
    }
}