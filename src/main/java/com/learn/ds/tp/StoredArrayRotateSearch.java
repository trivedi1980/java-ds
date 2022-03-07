package com.learn.ds.tp;

import java.util.Arrays;

public class StoredArrayRotateSearch {
    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return m;

            if (nums[l] <= nums[m]) {
                // left
                if (target > nums[m] || target < nums[l]) {
                    l = m + 1;
                } else {
                    r = m -1;
                }
            } else {
                // right
                if (target < nums[m] || target > nums[r]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[] { -1, -1 };

        result[0] = findIndex(nums, target, true);
        result[1] = findIndex(nums, target, false);

        return result;
    }

    private static int findIndex(int[] nums, int target, boolean isFirst) {
        int l = 0;
        int r = nums.length - 1;
        int index = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                if (index == -1) {
                    index = m;
                } else {
                    index = isFirst ? Math.min(index, m) : Math.max(index, m);
                }

                if (isFirst)
                    r = m -1;
                else
                    l = m + 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return index;
    }

    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int result = nums[0];
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[l] <= nums[m]) {
                result = Math.min(result, nums[l]);
                l = m + 1;
            } else {
                r = m -1;
                result = Math.min(result, nums[m]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[] {5,7,7,8,8,8}, 8)));
    }
}
