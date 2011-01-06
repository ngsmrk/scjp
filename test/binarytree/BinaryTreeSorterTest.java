package binarytree;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

/**
 * .
 *
 * @author Initial: amark
 * @version 1.0
 */
public class BinaryTreeSorterTest {

    @Test
    public void testAlphaSort() {

        BinaryTreeNode appleNode = new BinaryTreeNode("Apple");
        BinaryTreeNode grapeNode = new BinaryTreeNode("Grape");

        BinaryTreeNode bananaNode = new BinaryTreeNode("Banana");
        bananaNode.setLeft(appleNode);
        bananaNode.setRight(grapeNode);

        BinaryTreeNode peachNode = new BinaryTreeNode("Peach");

        BinaryTreeNode mangoNode = new BinaryTreeNode("Mango");
        mangoNode.setLeft(bananaNode);
        mangoNode.setRight(peachNode);

        BinaryTreeSorter sorter = new BinaryTreeSorter();
        List<String> sortedValues = sorter.sort(mangoNode);
        System.out.println(sortedValues);
        assertEquals(5, sortedValues.size());

        assertEquals("Apple", sortedValues.get(0));
        assertEquals("Banana", sortedValues.get(1));
        assertEquals("Grape", sortedValues.get(2));
        assertEquals("Mango", sortedValues.get(3));
        assertEquals("Peach", sortedValues.get(4));
    }

}
