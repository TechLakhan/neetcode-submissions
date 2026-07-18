class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return new int[0];

        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];

        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            // Remove smaller elements from the back
            while (!deque.isEmpty() &&
                    nums[deque.peekLast()] < nums[right]) {

                deque.pollLast();
            }

            // Add current index
            deque.offerLast(right);

            // Remove indices outside the window
            if (deque.peekFirst() < right - k + 1) {
                deque.pollFirst();
            }

            // Window formed
            if (right >= k - 1) {
                result[left] = nums[deque.peekFirst()];
                left++;
            }
        }
        return result;
    }
}
