class Solution {
    public int trap(int[] height) {
        int totalWater = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = 0;

        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }

        rightMax[height.length-1] = 0;
        for (int j = height.length-2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j+1], height[j+1]);
        }

        for (int i = 0; i < height.length; i++) {
            int water = Math.min(leftMax[i], rightMax[i]) - height[i];

            totalWater += Math.max(0, water);
        }
        return totalWater;
    }
}
