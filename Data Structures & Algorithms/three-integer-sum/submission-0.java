class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();


        for (int i=0;i<nums.length;i++) {
            int target = -nums[i];
            int left = i+1;
            int right = nums.length - 1;

            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    ArrayList<Integer> integers = new ArrayList<Integer>();
                    integers.add(nums[i]);
                    integers.add(nums[left]);
                    integers.add(nums[right]);
                    list.add(integers);

                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    // Skip duplicate values on the right
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < target) {
                    left++;
                }
                else {
                    right--;
                }
            }

        }
        return list;
    }
}
