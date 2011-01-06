/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scjp.maps;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.LinkedHashMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Angus
 */
public class LinkedHashMapTest {

    private Map<TestKey, String> myMap = new LinkedHashMap();

    public LinkedHashMapTest() {
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

    @Test
    public void testAddNulls() {
        myMap.put(null, "C");
        assertEquals("C", myMap.get(null));

        myMap.put(null, "D");
        assertEquals("D", myMap.get(null));
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

        // modification of value fools the set so a new element is added
        key.setValue("C");
        assertEquals(0, key.compareTo(key));
        assertEquals(key, key);
        assertFalse(myMap.containsKey(key));
        assertNull(myMap.put(key, "TEST"));

        assertEquals(++oldSize, myMap.size());
        System.out.println("Map after modification: " + myMap);
    }

    @Test
    public void testMapWithFixedHashCodeObject() {

       class FixedHashCodeKey {
           String value;

           FixedHashCodeKey(String value) {
               this.value = value;
           }

           @Override
           public boolean equals(Object o) {

               if (o instanceof FixedHashCodeKey) {
                   FixedHashCodeKey otherKey = (FixedHashCodeKey) o;
                   return value.equals(otherKey.value);
               }

               return false;
           }

           @Override
           public int hashCode() {
               return 1;
           }
       }

       // using a fixed hash code is ok (but not very efficient)
       final Map<FixedHashCodeKey, String> theMap = new LinkedHashMap();
       final FixedHashCodeKey key1 = new FixedHashCodeKey("key1");
       theMap.put(key1, "value1");

       final FixedHashCodeKey key2 = new FixedHashCodeKey("key2");
       theMap.put(key2, "value2");
       assertEquals(2, theMap.size());
    }

    @Test
    public void testMapWithFixedEqualsObject() {

       class AlwaysEqualKey {
           String value;

           AlwaysEqualKey(String value) {
               this.value = value;
           }

           @Override
           public boolean equals(Object o) {

               if (o instanceof AlwaysEqualKey) {
                   return true;
               }

               return false;
           }

           @Override
           public int hashCode() {
               return 1;
           }
       }

       // using equals that returns true basically means you cannot have more than 1 entry
       final Map<AlwaysEqualKey, String> theMap = new LinkedHashMap();
       final AlwaysEqualKey key1 = new AlwaysEqualKey("key1");
       theMap.put(key1, "value1");

       final AlwaysEqualKey key2 = new AlwaysEqualKey("key2");
       theMap.put(key2, "value2");
       assertEquals(1, theMap.size());
    }
}