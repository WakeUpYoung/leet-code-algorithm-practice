package com.wakeupyoung.array;

import com.wakeupyoung.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * url: <a href="https://leetcode.cn/problems/move-zeroes/">Move zeroes</a>
 */
public class MoveZero implements Solution<Void, List<Integer>> {
    @Override
    public Void resolve(List<Integer> input) {
        int[] array = input.stream().mapToInt(i -> i).toArray();
        int slow = 0, fast = 0;
        int newLength = 0;
        while (fast < array.length) {
            if (array[fast] != 0) {
                array[slow++] = array[fast++];
                newLength++;
            } else {
                fast++;
            }
        }
        System.out.println("newLength is " + newLength);
        for (int i = newLength; i < array.length; i++) {
            array[i] = 0;
        }
        System.out.println(Arrays.toString(array));
        return null;
    }

    public static void main(String[] args) {
        List<Integer> arrays = Arrays.asList(0, 1, 0, 3, 12);
        new MoveZero().resolve(arrays);
    }
}
