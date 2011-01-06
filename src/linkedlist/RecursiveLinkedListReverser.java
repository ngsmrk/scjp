package linkedlist;

/**
 * .
 *
 * @author Initial: amark
 * @version 1.0
 */
public class RecursiveLinkedListReverser implements LinkedListReverser {

    public LinkedListNode reverse(LinkedListNode head) {
        return reverse(head, null);
    }

    private LinkedListNode reverse(LinkedListNode node, LinkedListNode previous) {

        System.out.println("Current " + node);
        System.out.println("Previous " + previous);

        LinkedListNode next = node.getNext();
        if (next == null) {

            node.setNext(previous);
            System.out.println("Reached end " + node);
            System.out.println();

            return node;

        } else {
            LinkedListNode temp = reverse(next, node);

            System.out.println("Finished recursion " + node);
            System.out.println();

            node.setNext(previous);
            return temp;

        }
    }
}
