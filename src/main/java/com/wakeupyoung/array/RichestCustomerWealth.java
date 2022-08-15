package com.wakeupyoung.array;

import com.wakeupyoung.Solution;

import java.util.Arrays;
import java.util.Comparator;

public class RichestCustomerWealth implements Solution<Integer, int[][]> {
    @Override
    public Integer resolve(int[][] input) {
        return Arrays.stream(input).map(a -> {
            int sum = 0;
            for (int i : a) {
                sum += i;
            }
            return sum;
        }).max(Comparator.naturalOrder()).get();
    }

    public static void main(String[] args) {
        int[][] input = {
                {1,5}, {7,3}, {3, 5}
        };
        System.out.println(new RichestCustomerWealth().resolve(input));
    }

}
