class Solution {
    public int trap(int[] height) {
        int totalWater = 0;
        for (int i = 0; i < height.length; i++) {
            int leftMax = getLeftMax(height, i);
            int rightMax = getRightMax(height, i);

            int waterVolume = Math.min(leftMax, rightMax) - height[i];

            totalWater += Math.max(0, waterVolume);
        }
        return totalWater;
    }

    private static int getLeftMax(int[] height, int index) {
        int maxLeft = 0;
        while ( index > 0 ) {
            maxLeft = Math.max(maxLeft, height[index-1]);
            index--;
        }
        return maxLeft;
    }

    private static int getRightMax(int[] height, int index) {
        int maxRight = 0;
        while ( index < height.length - 1 ) {
            maxRight = Math.max(maxRight, height[index+1]);
            index++;
        }
        return maxRight;
    }
}
