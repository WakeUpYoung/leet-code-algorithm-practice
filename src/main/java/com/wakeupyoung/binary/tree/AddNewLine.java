package com.wakeupyoung.binary.tree;

import com.wakeupyoung.Solution;
import com.wakeupyoung.binary.tree.common.TreeNode;
import com.wakeupyoung.utils.DebugUtils;

/**
 * 给定一个二叉树的根root和两个整数 val 和depth，在给定的深度depth处添加一个值为 val 的节点行。
 * 注意，根节点root位于深度1。
 * <p/>
 * url: <a href="https://leetcode.cn/problems/add-one-row-to-tree">url</a>
 */
public class AddNewLine implements Solution<TreeNode, Input> {
    int depth = 1;
    int debugCount = 0;
    @Override
    public TreeNode resolve(Input input) {
        if (input.depth == 1) {
            return new TreeNode(input.val, input.root, null);
        }
        traversal(input.root, input);
        return input.root;
    }

    public void traversal(TreeNode root, Input input) {
        DebugUtils.print(debugCount++, "depth = " + depth);
        if (root == null) {
            DebugUtils.print(--debugCount, "depth = " + depth);
            return;
        }
        if (depth == input.depth - 1) {
            TreeNode newLeft = new TreeNode(input.val, root.left, null);
            TreeNode newRight = new TreeNode(input.val, null, root.right);
            root.left = newLeft;
            root.right = newRight;
        }
        depth++;
        traversal(root.left, input);
        traversal(root.right, input);
        depth--;
        DebugUtils.print(--debugCount, "depth = " + depth);
    }

    public static void main(String[] args) {
        Input input = new Input();
        TreeNode root = new TreeNode(4);
        TreeNode secondTreeLeft = new TreeNode(2, new TreeNode(3), new TreeNode(1));
        TreeNode secondTreeRight = new TreeNode(6, new TreeNode(5), null);
        root.left = secondTreeLeft;
        root.right = secondTreeRight;
        input.root = root;
        input.val = 1;
        input.depth = 2;
        TreeNode resolve = new AddNewLine().resolve(input);
        DebugUtils.printTreeNode(resolve);
    }

}

class Input {
    TreeNode root;
    int val;
    int depth;
}
