class Solution {
    public boolean isPalindrome(String str) {
        int right = 0;
        int left = str.length() - 1;

        while (right < left) {

            while (right < left && !Character.isLetterOrDigit(str.charAt(right))) {
                right++;
            }

            while (right < left && !Character.isLetterOrDigit(str.charAt(left))) {
                left--;
            }

            if (Character.toLowerCase(str.charAt(right)) != Character.toLowerCase(str.charAt(left))) {
                return false;
            }
            right++;
            left--;
        }
        return true;
    }
}
