class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int days = temperatures.length;
        int[] warmDays = new int[days];
        int left = 0;
        int count = 0;

        for (left = 0; left < days; left++) {
            int right = left + 1;

            while (right < days) {
                if (temperatures[left] < temperatures[right]) {
                    warmDays[left] = right - left;
                    break;
                }
                right++;
            }
        }
        return warmDays;
    }
}
