class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        // Build frequency arrays
        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            windowFreq[s2.charAt(i) - 'a']++;
        }

        // Check first window
        if (Arrays.equals(s1Freq, windowFreq)) {
            return true;
        }

        int left = 0;

        // Slide the window
        for (int right = s1.length(); right < s2.length(); right++) {

            // Add incoming character
            windowFreq[s2.charAt(right) - 'a']++;

            // Remove outgoing character
            windowFreq[s2.charAt(left) - 'a']--;

            left++;

            // Compare both frequency arrays
            if (Arrays.equals(s1Freq, windowFreq)) {
                return true;
            }
        }

        return false;
    }
}
