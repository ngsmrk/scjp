package linkedlist;

/**
 * .
 *
 * @author Initial: amark
 * @version 1.0
 *
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class LinkedListReverserTest {

    @Test
    public void testRevertRecursive() {

        LinkedListReverser listReverser = new RecursiveLinkedListReverser();
        testListReverser(listReverser);
    }

    @Test
    public void testRevertNonRecursive() {

        LinkedListReverser listReverser = new LoopingLinkedListReverser();
        testListReverser(listReverser);
    }

    private void testListReverser(LinkedListReverser listReverser) {
        
        LinkedListNode node1 = new LinkedListNode("A");

        LinkedListNode node2 = new LinkedListNode("B");
        node1.setNext(node2);
        assertEquals(node2, node1.getNext());

        LinkedListNode node3 = new LinkedListNode("C");
        node2.setNext(node3);
        assertEquals(node3, node2.getNext());

        assertNull(node3.getNext());

        LinkedListNode newNode = listReverser.reverse(node1);

        assertEquals(node3.getValue(), newNode.getValue());

        LinkedListNode newNode2 = newNode.getNext();
        assertEquals(node2.getValue(), newNode2.getValue());

        LinkedListNode newNode3 = newNode2.getNext();
        assertEquals(node1.getValue(), newNode3.getValue());

        assertNull(newNode3.getNext());
    }
}
