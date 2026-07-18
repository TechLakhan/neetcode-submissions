class Solution {
    public boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{' ) {
                characterStack.push(ch);
            }
            else {
                if (characterStack.isEmpty()) {
                    return false;
                }
                Character top = characterStack.pop();

                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return characterStack.isEmpty();
    }
}
