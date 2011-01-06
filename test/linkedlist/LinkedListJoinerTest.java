package linkedlist;

/**
 * .
 *
 * @author Initial: amark
 * @version 1.0
 */

import org.junit.Test;
import static junit.framework.Assert.*;

public class LinkedListJoinerTest {

    @Test
    public void testJoinList() {

        LinkedListNode headNode1 = new LinkedListNode("A");

        LinkedListNode node2 = new LinkedListNode("B");
        headNode1.setNext(node2);

        LinkedListNode node3 = new LinkedListNode("C");
        node2.setNext(node3);

        LinkedListNode headNode2 = new LinkedListNode("A2");

        LinkedListNode node4 = new LinkedListNode("B2");
        headNode2.setNext(node4);

        testJoin(headNode1, node3, headNode2, node4, new LoopingLinkedListJoiner());
    }

    @Test
    public void testJoinListRecursively() {

        LinkedListNode headNode1 = new LinkedListNode("A");

        LinkedListNode node2 = new LinkedListNode("B");
        headNode1.setNext(node2);

        LinkedListNode node3 = new LinkedListNode("C");
        node2.setNext(node3);

        LinkedListNode headNode2 = new LinkedListNode("A2");

        LinkedListNode node4 = new LinkedListNode("B2");
        headNode2.setNext(node4);

        testJoin(headNode1, node3, headNode2, node4, new RecursiveLinkedListJoiner());
    }

    private void testJoin(LinkedListNode headNode1, LinkedListNode node3, LinkedListNode headNode2, LinkedListNode node4, LinkedListJoiner joiner) {
        joiner.join(headNode1, headNode2);

        assertNull(headNode2.getNext().getNext());
        assertEquals(headNode2.getNext().getValue(), node4.getValue());
        assertEquals(headNode2.getValue(), node3.getNext().getValue());
    }
}
