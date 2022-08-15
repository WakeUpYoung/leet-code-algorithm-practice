package com.wakeupyoung.array;

import com.wakeupyoung.Solution;

/**
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，
 * 那么nums的前 k 个元素应该保存最终结果。
 * 将最终结果插入nums 的前 k 个位置后返回 k 。
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 链接：<a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array">url</a>
 */
public class DeleteDuplicated implements Solution<Integer, int[]> {
    @Override
    public Integer resolve(int[] input) {
        // The recommended one
        int slow = 1;
        int fast = 1;
        while (fast < input.length) {
            if (input[fast] != input[fast -1]) {
                input[slow] = input[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
        // my answer
        /*int slow = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[slow] != input[i]) {
                input[++slow] = input[i];
            }
        }
        return slow + 1;*/
    }

    public static void main(String[] args) {
        int[] input = {1,1,2};
        System.out.println(new DeleteDuplicated().resolve(input));
    }
}
