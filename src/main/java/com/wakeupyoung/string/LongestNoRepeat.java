package com.wakeupyoung.string;

import com.wakeupyoung.Solution;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">URL</a>
 */
public class LongestNoRepeat implements Solution<Integer, String> {
    @Override
    public Integer resolve(String input) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        char[] array = input.toCharArray();
        int maxLength = -1;
        while (right < array.length - 1) {
            if (set.contains(array[right + 1])) {
                set.remove(array[left]);
                right = ++left;
            } else {
                set.add(array[right]);
                right++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Integer n = new LongestNoRepeat().resolve("dvdf");
        System.out.println(n);
    }
}
