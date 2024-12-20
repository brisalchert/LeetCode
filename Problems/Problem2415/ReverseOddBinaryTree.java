//----------------------------------------------------------------------------------------------------------------------
//  2415. Reverse Odd Levels of Binary Tree
//
//  Given the root of a perfect binary tree, reverse the node values at each odd level of the tree.
//
//  - For example, suppose the node values at level 3 are [2,1,3,4,7,11,29,18], then it should become
//    [18,29,11,7,4,3,1,2].
//
//  Return the root of the reversed tree.
//
//  A binary tree is perfect if all parent nodes have two children and all leaves are on the same level.
//
//  The level of a node is the number of edges along the path between it and the root node.
//
//  Example 1:
//    Input: root = [2,3,5,8,13,21,34]
//    Output: [2,5,3,8,13,21,34]
//    Explanation:
//    The tree has only one odd level.
//    The nodes at level 1 are 3, 5 respectively, which are reversed and become 5, 3.
//----------------------------------------------------------------------------------------------------------------------

package Problem2415;

import java.util.ArrayList;
import java.util.List;

public class ReverseOddBinaryTree {
    public static void main(String[] args) {
        int[] input = {2, 3, 5, 8, 13, 21, 34};

        // Create binary tree
        TreeNode root = createBinaryTree(input, 0);

        // Reverse odd levels
        // root = reverseOddLevels(root);

        // Print new tree
        printTree(root);
    }

    public static TreeNode reverseOddLevels(TreeNode root) {
        return null;
    }

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode createBinaryTree(int[] input, int start) {
        // If the end of the input is reached, return null
        if (start >= input.length) {
            return null;
        }

        // Create the root node
        TreeNode root = new TreeNode(input[start]);

        // Create child nodes
        root.left = createBinaryTree(input, (2 * start + 1));
        root.right = createBinaryTree(input, (2 * start + 2));

        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        int height = height(root);
        ArrayList<Integer> treeVals = new ArrayList<>();

        for (int level = 1; level <= height; level++) {
            getCurrentLevel(root, level, treeVals);
        }

        System.out.println(treeVals);
    }

    public static int height(TreeNode root) {
        if (root == null)
            return 0;
        else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            if (leftHeight > rightHeight)
                return (leftHeight + 1);
            else
                return (rightHeight + 1);
        }
    }

    private static void getCurrentLevel(TreeNode current, int level, List<Integer> vals) {
        if (current == null) {
            return;
        }

        if (level == 1) {
            vals.add(current.val);
        } else if (level > 1) {
            getCurrentLevel(current.left, level - 1, vals);
            getCurrentLevel(current.right, level - 1, vals);
        }
    }
}
