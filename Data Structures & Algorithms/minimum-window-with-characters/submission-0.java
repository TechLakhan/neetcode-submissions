class Solution {
    public String minWindow(String s1, String target) {
        if (target.length() > s1.length()) {
            return "";
        }

        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> targetMap = new HashMap<>();
        
        int left = 0;
        int right = 0;
        int formed = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (char ch : target.toCharArray()) {
            targetMap.put(ch, targetMap.getOrDefault(ch, 0)+1);
        }
        int required = targetMap.size();
        while (right < s1.length()) {

            char ch = s1.charAt(right);
            s1Map.put(ch, s1Map.getOrDefault(ch, 0)+1);

            if (targetMap.containsKey(ch) &&
                    s1Map.get(ch).intValue() == targetMap.get(ch).intValue()) {
                formed++;
            }

            while (formed == required) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }
                char removed = s1.charAt(left);
                s1Map.put(removed, s1Map.get(removed)-1);

                if (targetMap.containsKey(removed) && s1Map.get(removed) < targetMap.get(removed)) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE
                ? ""
                : s1.substring(start, start + minLength);
    }
}
