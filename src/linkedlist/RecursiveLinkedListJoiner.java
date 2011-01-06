package linkedlist;

/**
 * .
 *
 * @author Initial: amark
 * @version 1.0
 */
public class RecursiveLinkedListJoiner implements LinkedListJoiner {

    public void join(LinkedListNode node1, LinkedListNode node2) {

        LinkedListNode lastNode = getLastNodeRecursively(node1);
        lastNode.setNext(node2);
    }

    private LinkedListNode getLastNodeRecursively(LinkedListNode node) {

        if (node.getNext() == null) {
            return node;
        } else {
            return getLastNodeRecursively(node.getNext());
        }
    }
}
