class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
             set.add(num);
        }

        for (int num : nums) {
            int streak = 0, 
            curr = num;
            while (set.contains(curr)) {
                streak++;
                curr++;
            }
            result = Math.max(result, streak);
        }
        return result;
    }
}