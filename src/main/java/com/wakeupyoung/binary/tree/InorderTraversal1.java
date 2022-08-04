package com.wakeupyoung.binary.tree;

import com.wakeupyoung.Solution;
import com.wakeupyoung.binary.tree.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回它的 <p>中序</p> 遍历 。
 * Easy
 */
public class InorderTraversal1 implements Solution<List<Integer>, TreeNode> {
    public List<Integer> res = new LinkedList<>();

    @Override
    public List<Integer> resolve(TreeNode input) {
        traversal(input);
        return res;
    }

    void traversal(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        traversal(treeNode.left);
        res.add(treeNode.val);
        traversal(treeNode.right);
    }

    public static void main(String[] args) {
        TreeNode exampleRoot = new TreeNode(1);
        exampleRoot.right = new TreeNode(2, new TreeNode(3), null);
        InorderTraversal1 solution = new InorderTraversal1();
        List<Integer> resolve = solution.resolve(exampleRoot);
        System.out.println(Arrays.toString(solution.res.toArray()));
    }
}
