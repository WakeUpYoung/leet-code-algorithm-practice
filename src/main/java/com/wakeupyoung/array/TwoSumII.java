package com.wakeupyoung.array;

import com.wakeupyoung.Solution;

import java.util.Arrays;
import java.util.List;

/**
 * 给你一个下标从 1 开始的整数数组numbers ，该数组已按 非递减顺序排列 ，请你从数组中找出满足相加之和等于目标数target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * 你所设计的解决方案必须只使用常量级的额外空间。
 * <p>
 * 链接：<a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted">URL</a>
 */
public class TwoSumII implements Solution<List<Integer>, Input> {
    @Override
    public List<Integer> resolve(Input input) {
        int[] numbers = input.numbers;
        int target = input.target;
        // official solution
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return List.of(left + 1, right + 1);
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        // my solution
        /*int slow = 0, fast = 0;
        int index1, index2;
        while (slow < numbers.length) {
            fast++;
            if (numbers[slow] + numbers[fast] == target) {
                index1 = slow;
                index2 = fast;
                return List.of(index1 + 1, index2 + 1);
            } else {
                if (fast == numbers.length - 1) {
                    slow++;
                    fast = slow;
                }
            }
        }*/
        return List.of(-1, -1);
    }

    public static void main(String[] args) {
        Input input = new Input();
        input.numbers = new int[]{2,3,4};
        input.target = 6;
        List<Integer> resolve = new TwoSumII().resolve(input);
        System.out.println(Arrays.toString(resolve.toArray()));

    }

}

class Input {
    int[] numbers;
    int target;
}
