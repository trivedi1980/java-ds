package com.learn.ds.cs;

public class FindCorruptNums {
    public static int[] findNumbers(int[] nums) {
        int[] pair = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
                i--;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                pair[0] = nums[i];
                pair[1] = i + 1;
                break;
            }
        }
        return pair;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = FindCorruptNums.findNumbers(new int[] { 3, 1, 2, 5, 2 });
        System.out.println(nums[0] + ", " + nums[1]);
        nums = FindCorruptNums.findNumbers(new int[] { 3, 1, 2, 3, 6, 4 });
        System.out.println(nums[0] + ", " + nums[1]);
    }
}
