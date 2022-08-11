package com.wakeupyoung.string;

import com.wakeupyoung.Solution;

/**
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 * <p>
 * <a href="https://leetcode.cn/problems/reformat-the-string">url</a>
 */
public class ReformatString implements Solution<String, String> {
    @Override
    public String resolve(String input) {
        String nums = input.replaceAll("\\D+", "");
        String words = input.replaceAll("\\d+", "");
        StringBuilder result = new StringBuilder();
        if (nums.length() == words.length() + 1) {
            for (int i = 0; i < words.length(); i++) {
                result.append(nums.charAt(i)).append(words.charAt(i));
            }
            result.append(nums.charAt(nums.length() - 1));
        } else if (nums.length() + 1 == words.length()) {
            for (int i = 0; i < nums.length(); i++) {
                result.append(words.charAt(i)).append(nums.charAt(i));
            }
            result.append(words.charAt(words.length() - 1));
        } else if (nums.length() == words.length()) {
            for (int i = 0; i < words.length(); i++) {
                result.append(nums.charAt(i)).append(words.charAt(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "covid2019";
        String resolve = new ReformatString().resolve(input);
        System.out.println("result it " + resolve);
    }
}
