package binarytree;

import java.util.List;
import java.util.ArrayList;

/**
 * .
 *
 * @author Initial: amark
 * @version 1.0
 */
public class BinaryTreeSorter {

    public List<String> sort(BinaryTreeNode node) {
        
        final List<String> output = new ArrayList<String>();

        getValue(node, output);

        return output;
    }

    private void getValue(BinaryTreeNode node, List<String> output) {

        if (node.getLeft() == null || node.getRight() == null) {

            output.add(node.getValue());

        } else {

            getValue(node.getLeft(), output);
            output.add(node.getValue());
            getValue(node.getRight(), output);

        }

    }
}
