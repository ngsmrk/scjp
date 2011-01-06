package linkedlist;

/**
 * .
 *
 * @author Initial: amark
 * @version 1.0
 */
public class LoopingLinkedListJoiner implements LinkedListJoiner {

    public void join(LinkedListNode node1, LinkedListNode node2) {

        LinkedListNode lastNode = getLastNode(node1);
        lastNode.setNext(node2);
    }

    private LinkedListNode getLastNode(LinkedListNode node) {


        while (node.getNext() != null) {
            node = node.getNext();
        }

        return node;
    }
}
