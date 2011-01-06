/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scjp;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Angus
 */
public class PassByRefTest {

    public PassByRefTest() {
    }

    @Test
    public void testString() {

        class Modifier {

            Modifier() {
            }

            public void modify(String param) {
                param = "2";
            }
        }

        // Strings are not pass by reference - reassignment in a method does not change the original value
        String y = "1";
        Modifier mod = new Modifier();
        mod.modify(y);
        assertEquals("1", y);
    }

    @Test
    public void testArray() {

        class Modifier {

            Modifier() {
            }

            public void modify(String[] param) {
                param = new String[]{};
            }
        }

        // arrays are not pass by reference - reassignment in a method does not change the original value
        String[] array = {"1", "2"};
        Modifier mod = new Modifier();
        mod.modify(array);
        assertEquals(2, array.length);
        assertEquals("1", array[0]);
        assertEquals("2", array[1]);
    }

    @Test
    public void testList() {
        class Modifier {

            Modifier() {
            }

            public void modify(List<String> param) {
                param = new ArrayList();
            }
        }

        // lists are not pass by reference - reassignment in a method does not change the original value
        List<String> list = new ArrayList();
        list.add("1");
        list.add("2");
        Modifier mod = new Modifier();
        mod.modify(list);
        assertEquals(2, list.size());
        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
    }

    @Test
    public void testMap() {
        class Modifier {

            Modifier() {
            }

            public void modify(Map<String, String> param) {
                param = new HashMap<String, String>();
            }
        }

        // maps are not pass by reference - reassignment in a method does not change the original value
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "test1");
        map.put("2", "test2");
        Modifier mod = new Modifier();
        mod.modify(map);
        assertEquals(2, map.size());
        assertEquals("test1", map.get("1"));
        assertEquals("test2", map.get("2"));
    }

    @Test
    public void testClass() {

        class Inner {

            String value;

            Inner(String value) {
                this.value = value;
            }

            public String getValue() {
                return value;
            }
        }

        class Modifier {

            Modifier() {
            }

            public void modify(Inner param) {
                param = new Inner("new");
            }
        }

        // objects are not pass by reference - reassignment in a method does not change the original value
        Inner inner = new Inner("original");
        Modifier mod = new Modifier();
        mod.modify(inner);
        assertEquals("original", inner.getValue());
    }

    @Test
    public void testWrapper() {

        class Modifier {

            Modifier() {
            }

            public void modify(Integer param) {
                param = 2;
            }
        }

        // wrappers are not pass by reference - reassignment in a method does not change the original value
        Integer y = 1;
        Modifier mod = new Modifier();
        mod.modify(y);
        assertEquals(new Integer(1), y);

        // test with boxing
        int z = 1;
        mod = new Modifier();
        mod.modify(z);
        assertEquals(1, z);
    }

    @Test
    public void testPrimitive() {

        int x = 1;

        class Modifier {

            Modifier() {
            }

            public void modify(int param) {
                param = 2;
            }
        }

        // primitives are not pass by reference - reassignment in a method does not change the original value
        Modifier mod = new Modifier();
        mod.modify(x);
        assertEquals(1, x);

        // test with unboxing
        Integer y = 1;
        mod = new Modifier();
        mod.modify(y);
        assertEquals(new Integer(1), y);
    }
}
