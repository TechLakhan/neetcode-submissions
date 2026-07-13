class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Set<Integer> set = new HashSet<>();

        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int streak = 1;
                int curr = num;

                while (set.contains(curr + 1)) {
                    curr++;
                    streak++;
                }
                result = Math.max(result, streak);
            }
        }
        return result;
    }
}