class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length());
            sb.append('#');
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            int j = i;

            // Find the '#'
            while (s.charAt(j) != '#') {
                j++;
            }

            // Parse length
            int length = Integer.parseInt(s.substring(i, j));

            // Read the actual string
            String word = s.substring(j + 1, j + 1 + length);
            result.add(word);

            // Move to next encoded string
            i = j + 1 + length;
        }

        return result;
    }
}
