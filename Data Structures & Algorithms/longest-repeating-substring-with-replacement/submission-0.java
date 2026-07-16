class Solution {
    public int characterReplacement(String s, int target) {
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int replacement = 0;
        int maxLength = 0;

        for (right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0)+1);
            while (true) {
                maxFreq = 0;
                for (Integer count : map.values()) {
                    maxFreq = Math.max(maxFreq, count);
                }

                replacement = (right -left + 1) - maxFreq;

                if (replacement <= target) {
                    break;
                }
                else {
                    map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0)-1);
                    if (map.get(s.charAt(left)) == 0) {
                        map.remove(s.charAt(left));
                    }
                    left++;
                }
            }
            maxLength = Math.max(maxLength, (right - left + 1));
        }
        return maxLength;
    }
}
