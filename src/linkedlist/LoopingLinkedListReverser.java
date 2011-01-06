package linkedlist;

/**
 * .
 *
 * @author Initial: amark
 * @version 1.0
 */
public class LoopingLinkedListReverser implements LinkedListReverser {


    public LinkedListNode reverse(LinkedListNode head) {

        LinkedListNode next;
        LinkedListNode prev = null;
        while (head != null) {

            System.out.println("Current " + head);
            System.out.println("Previous " + prev);

            next = head.getNext();
            head.setNext(prev);

            prev = head;
            head = next;
        }

        return prev;
    }
}
