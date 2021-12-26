package com.learn.ds.tp;

import java.util.ArrayList;
import java.util.List;

public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
    }

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subArrays = new ArrayList<>();
        int prod = 1;
        int ws = 0;
        int we = 0;
        while (we < arr.length) {
            prod = prod * arr[we];
            if (prod >= target) {
                while (prod >= target && ws < arr.length) {
                    prod = prod / arr[ws++];
                }
            }
            List<Integer> array = new ArrayList<>();
            for (int i = we; i >= ws; i--) {
                array.add(0, arr[i]);
                subArrays.add(new ArrayList<>(array));
            }
            we++;
        }
        return subArrays;
    }
}
