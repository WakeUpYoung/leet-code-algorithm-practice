package com.wakeupyoung.array;

import com.wakeupyoung.Solution;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * <p>
 * 整数 a 比整数 b 更接近 x 需要满足：
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 * <p>
 * 链接：<a href="https://leetcode.cn/problems/find-k-closest-elements">URL</a>
 */
public class FindKClosest implements Solution<List<Integer>, InputA> {
    @Override
    public List<Integer> resolve(InputA input) {
        int[] arr = input.arr;
        int k = input.k;
        int x = input.x;
        // solution
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        Integer[] result = new Integer[k];
        while(left <= right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] < x) {
                left = mid + 1;
            } else if (arr[mid] > x) {
                right = mid - 1;
            } else if (arr[mid] == x) {
                break;
            }
        }
        System.out.println(mid);
        int start = findStart(mid, arr.length, k);
        System.out.println("start:" + start);
        for (int i = 0; i < k; ++i) {
            result[i] = arr[start++];
        }
        return Arrays.asList(result);
    }

    private int findStart(int mid, int length, int k) {
        if (mid <= k >> 1) {
            return 0;
        }
        if (mid - (k >> 1) + k > length - 1) {
            return mid - (k >> 1) - (mid - (k >> 1) + k - length);
        }
        return mid - (k >> 1);
    }

    public static void main(String[] args) {
        int[] arr = {-2,-1,1,2,3,4,5};
        InputA input = new InputA();
        input.arr = arr;
        input.k = 7;
        input.x = 3;
        List<Integer> resolve = new FindKClosest().resolve(input);
        System.out.println("result is " + Arrays.toString(resolve.toArray()));
    }
}

class InputA {
    int[] arr;
    int k;
    int x;
}
