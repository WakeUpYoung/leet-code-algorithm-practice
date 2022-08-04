package com.wakeupyoung.utils;

import com.wakeupyoung.binary.tree.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DebugUtils {
    private DebugUtils(){}

    public static void print(int count, String str) {
        for (int i = 0; i < count; i ++) {
            System.out.print("\t");
        }
        System.out.println(str);
    }

    public static void preorderTree(TreeNode treeNode, List<Integer> debugList) {
        if (treeNode == null) {
            debugList.add(null);
            return;
        }
        debugList.add(treeNode.val);
        preorderTree(treeNode.left, debugList);
        preorderTree(treeNode.right, debugList);
    }

    public static void inorderTree(TreeNode treeNode, List<Integer> debugList) {
        if (treeNode == null) {
            debugList.add(null);
            return;
        }
        inorderTree(treeNode.left, debugList);
        debugList.add(treeNode.val);
        inorderTree(treeNode.right, debugList);
    }

    public static void printTreeNode(TreeNode treeNode) {
        List<Integer> debugList = new LinkedList<>();
        preorderTree(treeNode, debugList);
        System.out.println(Arrays.toString(debugList.toArray()));
    }

}
