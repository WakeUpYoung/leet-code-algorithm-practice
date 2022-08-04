package com.wakeupyoung.binary.tree;

import com.wakeupyoung.Solution;
import com.wakeupyoung.binary.tree.common.TreeNode;
import com.wakeupyoung.utils.DebugUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树.
 * <p>
 * url <a href="https://leetcode.cn/problems/unique-binary-search-trees-ii">Link</a>
 */
public class UniqueSearchTree2 implements Solution<List<TreeNode>, Integer> {
    int debugCount = 0;

    @Override
    public List<TreeNode> resolve(Integer input) {
        return build(1, input);
    }

    List<TreeNode> build(int left, int right) {
        DebugUtils.print(debugCount++, "left = " + left + ",right = " + right);
        List<TreeNode> res = new LinkedList<>();
        if (left > right) {
            DebugUtils.print(--debugCount, "left = " + left + ",right = " + right);
            res.add(null);
            return res;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftTree = build(left, i - 1);
            List<TreeNode> rightTree = build(i + 1, right);
            for (TreeNode leftNode : leftTree) {
                for (TreeNode rightNode : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    res.add(root);
                }
            }
        }
        DebugUtils.print(--debugCount, "left = " + left + ",right = " + right);
        return res;
    }

    public static void main(String[] args) {
        UniqueSearchTree2 solution = new UniqueSearchTree2();
        List<TreeNode> resolve = solution.resolve(3);
        System.out.println(resolve.size());
        for (TreeNode treeNode : resolve) {
            List<Integer> debugList = new LinkedList<>();
            DebugUtils.printTreeNode(treeNode);
        }
    }
}
