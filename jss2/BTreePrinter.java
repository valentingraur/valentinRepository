package jss2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BTreePrinter {


    public void printBTree(MyLinkedBinaryTree<String> tree) {
        int maxLevel = maxLevel(tree.root);

        printBinaryTreeNodeInternal(Collections.singletonList(tree.root), 1, maxLevel);
    }

    private void printBinaryTreeNodeInternal(List<BinaryTreeNode<String>> binaryTreeNodes, int level, int maxLevel) {
        if (binaryTreeNodes.isEmpty() || isAllElementsNull(binaryTreeNodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1 ;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<BinaryTreeNode<String>> newBinaryTreeNodes = new ArrayList<BinaryTreeNode<String>>();
        for (BinaryTreeNode<String> binaryTreeNode : binaryTreeNodes) {
            if (binaryTreeNode != null) {
                System.out.print(binaryTreeNode.element);
                newBinaryTreeNodes.add(binaryTreeNode.left);
                newBinaryTreeNodes.add(binaryTreeNode.right);
            } else {
                newBinaryTreeNodes.add(null);
                newBinaryTreeNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < binaryTreeNodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (binaryTreeNodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (binaryTreeNodes.get(j).left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (binaryTreeNodes.get(j).right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println();
        }

        printBinaryTreeNodeInternal(newBinaryTreeNodes, level + 1, maxLevel);
    }

    private void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private int maxLevel(BinaryTreeNode<String> binaryTreeNode) {
        if (binaryTreeNode == null)
            return 0;

        return Math.max(maxLevel(binaryTreeNode.left), maxLevel(binaryTreeNode.right)) + 1;
    }

    private boolean isAllElementsNull(List list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }}