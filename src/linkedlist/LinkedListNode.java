package linkedlist;

/**
 * .
 *
 * @author Initial: amark
 * @version 1.0
 */
public class LinkedListNode {

    private String value;

    private LinkedListNode next;

    public LinkedListNode(String value) {

        this.value = value;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public String getValue() {
        return value;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "LinkedListNode{" +
                "value='" + value + '\'' +
                '}';
    }
}
