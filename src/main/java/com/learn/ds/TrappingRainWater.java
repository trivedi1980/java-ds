package com.learn.ds;

public class TrappingRainWater {
    public static int trap(int[] height) {
        int[] leftMax = new int[height.length];
        leftMax[0] = 0;
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i -1], height[i-1]);
        }

        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = 0;
        for (int i = height.length - 2; i >=0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }

        int trapCount = 0;
        for (int i = 0; i < height.length; i++) {
            if (leftMax[i] > height[i] && rightMax[i] > height[i]) {
                int min = Math.min(leftMax[i], rightMax[i]);
                trapCount = trapCount + (min - height[i]);
            }
        }
        return trapCount;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
